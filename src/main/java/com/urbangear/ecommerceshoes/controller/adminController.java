package com.urbangear.ecommerceshoes.controller;

import com.urbangear.ecommerceshoes.domain.contactForm;
import com.urbangear.ecommerceshoes.domain.order;
import com.urbangear.ecommerceshoes.domain.shoe;
import com.urbangear.ecommerceshoes.service.shoeService;
import com.urbangear.ecommerceshoes.service.orderService;
import com.urbangear.ecommerceshoes.service.contactFormService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private shoeService shoeService;
    @Autowired
    private contactFormService contactFormService;
    @Autowired
    private orderService orderService;

    @GetMapping("/insert")
    public String showAdmin(HttpSession session) {

        // Check if the admin is logged in
        if (session.getAttribute("session") == null) {
            // Redirect to the login page if the admin is not logged in
            return "redirect:/admin/error";
        }
        return "admin_Insert";
    }

    @PostMapping("/insertItem")
    public String insertItem(
            @RequestParam("itemName") String itemName,
            @RequestParam("itemDescription") String itemDescription,
            @RequestParam("itemPrice") double itemPrice,
            @RequestParam("itemCategory") String itemCategory,
            @RequestParam("itemImage") MultipartFile itemImage
    ) {
        try {
            // Convert MultipartFile to byte[]
            byte[] imageBytes = itemImage.getBytes();

            // Create a new shoe instance
            shoe newShoe = new shoe(itemName, itemDescription, itemPrice, itemCategory, imageBytes);

            // Save the new shoe to the database
            shoeService.saveShoe(newShoe);

            // Redirect to a success page or return a success response
            return "redirect:/admin/inventory";  // You can customize the success page URL

        } catch (Exception e) {
            // Handle exceptions, e.g., file processing error or database error
            e.printStackTrace();
            return "redirect:/admin/error";  // You can customize the error page URL
        }
    }

    @GetMapping("/inventory")
    public String showInventory(Model model, HttpSession session) {
        // Check if the admin is logged in
        if (session.getAttribute("session") == null) {
            // Redirect to the login page if the admin is not logged in
            return "redirect:/admin/error";
        }
        // Fetch the list of shoes from the service
        List<shoe> shoes = shoeService.getAllShoes();

        // Convert each shoe's image to Base64 and add it to the model
        List<String> base64Images = shoes.stream()
                .map(s -> {
                    byte[] image = s.getImage();
                    if (image != null) {
                        return "data:image/png;base64," + Base64.getEncoder().encodeToString(image);
                    } else {
                        // Handle the case where the image is null (provide a default or skip)
                        return "data:image/png;base64,";
                    }
                })
                .collect(Collectors.toList());

        // Add the list of Base64-encoded images to the model
        model.addAttribute("base64Images", base64Images);

        // Add the list of shoes to the model
        model.addAttribute("shoes", shoes);

        // Return the view name
        return "admin_Inventory";
    }

    @GetMapping("/editItem")
    public String showEditItemForm(@RequestParam(name = "id") Long id, Model model, HttpSession session) {
        // Check if the admin is logged in
        if (session.getAttribute("session") == null) {
            // Redirect to the login page if the admin is not logged in
            return "redirect:/admin/error";
        }
        // Fetch the shoe by id
        Optional<shoe> optionalShoeToEdit = shoeService.getShoeById(id);

        // Check if the shoe is present in the Optional
        if (optionalShoeToEdit.isPresent()) {
            shoe shoeToEdit = optionalShoeToEdit.get();

            // Make sure the image property is not null
            if (shoeToEdit.getImage() != null) {
                // Convert the image to Base64
                String base64Image = "data:image/png;base64," + Base64.getEncoder().encodeToString(shoeToEdit.getImage());

                // Add the Base64-encoded image to the model
                model.addAttribute("base64Image", base64Image);

                // Add shoe data to the model
                model.addAttribute("shoe", shoeToEdit);

                // ...
                return "admin_Edit_Item";
            } else {
                // Handle the case where the image is null
                return "redirect:/admin/error";
            }
        } else {
            // Handle the case where the shoe with the given id is not found
            return "redirect:/admin/inventory";
        }
    }



    @PostMapping("/saveEditedShoe")
    public String saveEditedShoe(
            @ModelAttribute shoe editedShoe,
            @RequestParam("itemImage") MultipartFile itemImage
    ) {
        try {
            // Check if a new image is provided
            if (!itemImage.isEmpty()) {
                // If a new image is provided, update the shoe's image
                editedShoe.setImage(itemImage.getBytes());
            } else {
                // No new image provided, check if the shoe being updated already has an image
                Optional<shoe> optionalShoe = shoeService.getShoeById(editedShoe.getId());
                optionalShoe.ifPresent(existingShoe -> {
                    // Use the existing image if available
                    editedShoe.setImage(existingShoe.getImage());
                });
            }

            // Save the edited shoe to the database
            shoeService.saveShoe(editedShoe);

            // Redirect to inventory after successful edit
            return "redirect:/admin/inventory";
        } catch (Exception e) {
            // Handle exceptions, e.g., file processing error or database error
            e.printStackTrace();
            // Redirect to an error page
            return "redirect:/admin/error";
        }
    }


    @GetMapping("/deleteShoe/{id}")
    public String deleteShoe(@PathVariable Long id) {
        try {
            // Delete the shoe by ID
            shoeService.deleteShoeById(id);

            // Redirect to inventory after successful deletion
            return "redirect:/admin/inventory";
        } catch (Exception e) {
            // Handle exceptions, e.g., database error
            e.printStackTrace();
            // Redirect to an error page
            return "redirect:/admin/error";
        }
    }

    @GetMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable Long id) {
        try {
            // Delete the order by ID
            orderService.deleteOrder(id);

            // Redirect to orders after successful deletion
            return "redirect:/admin/requested";
        } catch (Exception e) {
            // Handle exceptions, e.g., database error
            e.printStackTrace();
            // Redirect to an error page
            return "redirect:/admin/error";
        }
    }

    @GetMapping("/error")
    public String showErrorPage() {
        return "errorPage";
    }

    @GetMapping("/requested")
    public String showRequested(Model model, HttpSession session) {
        // Check if the admin is logged in
        if (session.getAttribute("session") == null) {
            // Redirect to the login page if the admin is not logged in
            return "redirect:/admin/error";
        }

        // Fetch the list of orders from the service
        List<order> orders = orderService.getAllOrders();

        // Convert each order item's image to Base64 and add it to the model
        List<String> base64OrderImages = orders.stream()
                .map(s -> {
                    byte[] image = s.getImage();
                    if (image != null) {
                        return "data:image/png;base64," + Base64.getEncoder().encodeToString(image);
                    } else {
                        // Handle the case where the image is null (provide a default or skip)
                        return "data:image/png;base64,";
                    }
                })
                .collect(Collectors.toList());

        // Add the list of Base64-encoded images to the model
        model.addAttribute("base64OrderImages", base64OrderImages);

        // Add the list of orders to the model
        model.addAttribute("orders", orders);
        return "admin_Requested";
    }

    @GetMapping("/contacted")
    public String showContacted(Model model, HttpSession session) {
        // Check if the admin is logged in
        if (session.getAttribute("session") == null) {
            // Redirect to the login page if the admin is not logged in
            return "redirect:/admin/error";
        }
        // Fetch the list of messages from the service
        List<contactForm> contactForms = contactFormService.getAllContactForms();

        // Add the list of shoes to the model
        model.addAttribute("contactForms", contactForms);

        return "admin_Contact";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletRequest request) {
        // Clear session attributes
        session.removeAttribute("session");

        // Invalidate the admin session
        session.invalidate();

        // Expire any existing cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
            }
        }

        return "redirect:/api/users/login";
    }


    @GetMapping("/welcomeAdmin")
    public String showAdminWelcome(HttpSession session){
        // Check if the admin is logged in
        if (session.getAttribute("session") == null) {
            // Redirect to the login page if the admin is not logged in
            return "redirect:/admin/error";
        }
        return "admin_welcome";
    }
}

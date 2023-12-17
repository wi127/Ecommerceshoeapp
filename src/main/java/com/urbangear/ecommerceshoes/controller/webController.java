package com.urbangear.ecommerceshoes.controller;

import com.urbangear.ecommerceshoes.domain.order;
import com.urbangear.ecommerceshoes.domain.shoe;
import com.urbangear.ecommerceshoes.service.contactFormService;
import com.urbangear.ecommerceshoes.service.shoeService;
import com.urbangear.ecommerceshoes.service.orderService;
import com.urbangear.ecommerceshoes.domain.contactForm;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/web")
public class webController {
    @Autowired
    private contactFormService contactFormService;
    @Autowired
    private shoeService shoeService;
    @Autowired
    private orderService orderService;


    @GetMapping("/home")
    public String showHomePage(Model model, HttpSession session) {
        // Check if the user is logged in
        if (session.getAttribute("session") == null) {
            // Redirect to the login page if the user is not logged in
            return "redirect:/web/error";
        }

        // Fetch shoes data based on categories
        List<shoe> sportShoes = shoeService.findByCategory("Sport Shoes");
        List<shoe> safetyShoes = shoeService.findByCategory("Safety Shoes");
        List<shoe> moreShoes = shoeService.getAllShoes();

        // Decode and convert images for each category
        List<String> sportShoeImages = decodeImages(sportShoes);
        List<String> safetyShoeImages = decodeImages(safetyShoes);
        List<String> moreShoeImages = decodeImages(moreShoes);

        // Add the shoe lists and corresponding Base64-encoded images to the model
        model.addAttribute("sportShoes", sportShoes);
        model.addAttribute("safetyShoes", safetyShoes);
        model.addAttribute("moreShoes", moreShoes);
        model.addAttribute("sportShoeImages", sportShoeImages);
        model.addAttribute("safetyShoeImages", safetyShoeImages);
        model.addAttribute("moreShoeImages", moreShoeImages);

        return "home";
    }


    private List<String> decodeImages(List<shoe> shoes) {
        List<String> base64Images = new ArrayList<>();
        for (shoe shoe : shoes) {
            base64Images.add(decodeImage(shoe.getImage()));
        }
        return base64Images;
    }

    private String decodeImage(byte[] imageData) {
        try {
            // Check if imageData is null or empty
            if (imageData == null || imageData.length == 0) {
                return "";
            }

            return "data:image/png;base64," + Base64.getEncoder().encodeToString(imageData);
        } catch (Exception e) {
            e.printStackTrace();
            return ""; // Return an empty string or handle appropriately
        }
    }

    @PostMapping("/sendMessage")
    public String sendMessage(@ModelAttribute("contactForm") contactForm contactForm) {
        // Save the form data using the service
        contactFormService.saveContactForm(contactForm);

        // Redirect the user to the contact page
        return "redirect:/web/contact";
    }

    @GetMapping("/error")
    public String showErrorPage() {
        return "errorPage";
    }



    @GetMapping("/contact")
    public String showContactForm(Model model, HttpSession session) {
        // Check if the user is logged in
        if (session.getAttribute("session") == null) {
            // Redirect to the login page if the user is not logged in
            return "redirect:/web/error";
        }
        // Add the contactForm object to the model
        model.addAttribute("contactForm", new contactForm());

        return "contact";
    }


    @GetMapping("/checkout")
    public String showCheckout(HttpSession session) {
        // Check if the user is logged in
        if (session.getAttribute("session") == null) {
            // Redirect to the login page if the user is not logged in
            return "redirect:/web/error";
        }

        return "checkout";
    }

    @GetMapping("/payment")
    public String showPayment(HttpSession session) {
        // Check if the user is logged in
        if (session.getAttribute("session") == null) {
            // Redirect to the login page if the user is not logged in
            return "redirect:/web/error";
        }
        return "payment";
    }



    @PostMapping("/saveOrder")
    @ResponseBody
    public String saveOrder(@RequestBody List<order> orderItems, HttpSession session) {
        try {

            String username = (String) session.getAttribute("username");
            // Loop through order items and save to the database
            for (order orderItem : orderItems) {

                orderItem.setUser(username);

                // Save the order to the database (you need a repository for this)
                orderService.saveOrder(orderItem);
            }

            return "redirect:/web/success";
        } catch (Exception e) {
            // Handle exception (log or return an error message)
            return "redirect:/web/error";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletRequest request) {
        // Clear session attributes
        session.removeAttribute("session");

        // Invalidate the user session
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

    @RequestMapping("/error")
    public String handleError() {
        // Provide a custom error page or redirect to a specific page
        return "orderErrorPage";
    }

    @RequestMapping("/success")
    public String handleSuccess() {
        // Provide a custom error page or redirect to a specific page
        return "orderSuccessPage";
    }


}

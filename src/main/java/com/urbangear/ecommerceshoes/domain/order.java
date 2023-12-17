// com/urbangear/ecommerceshoes/model/ShoeRequested.java

package com.urbangear.ecommerceshoes.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "product_size")
    private String itemSize;

    @Lob
    @Column(name = "product_image", columnDefinition = "LONGBLOB")
    private byte[] image;
    @Column(name= "users")
    private String user;



    // Getters and setters

    public order() {
    }

    public order(Long id, String itemName, String description, double price, String itemSize, byte[] image, String user) {
        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.itemSize = itemSize;
        this.image = image;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getItemSize() {
        return itemSize;
    }

    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] productImage) {
        this.image = productImage;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}

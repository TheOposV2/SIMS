package com.project.SIMS.model;

import jakarta.persistence.*;

@Entity // Tag in spring to determinate hat this class is object stored in DB
@Table(name = "products")
public class Product {
    @Id // tag for primary key
    private int id;
    private String name;
    private String description;
    private int quantity;
    private float price;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    // default constructor for spring purposes
    public Product() {
    }

    public void setSupplier(Supplier supplier){
        this.supplier = supplier;
    }
    //Getters and Setters
    public int getSupplier_id() {
        return supplier != null ? supplier.getId() : 0; // ternary operator (condition ? valueIfTrue : valueIfFalse)
    }

    public void setSupplier_id(int supplier_id) {
        if (this.supplier == null) {
            this.supplier = new Supplier();
        }
        this.supplier.setId(supplier_id);}

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

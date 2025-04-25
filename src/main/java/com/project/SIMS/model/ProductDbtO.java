package com.project.SIMS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductDbtO {

    @Id // tag for primary key
    private int id;
    private String name;
    private String description;
    private int quantity;
    private float price;
    private int supplier_id;

    public ProductDbtO(int id, String name, String description, int quantity, float price, int supplier_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.supplier_id = supplier_id;
    }

    public ProductDbtO(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }
}

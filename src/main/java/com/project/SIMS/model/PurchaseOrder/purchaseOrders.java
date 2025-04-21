package com.project.SIMS.model.PurchaseOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class purchaseOrders {
    @Id
    private int id;
    private int product_id;
    private int supplier_id;
    private int quantity;
    private String purchase_date;
    private String status;

    public purchaseOrders() {
    }

    public purchaseOrders(int id, int product_id, int supplier_id, int quantity, String purchase_date, String status) {
        this.id = id;
        this.product_id = product_id;
        this.supplier_id = supplier_id;
        this.quantity = quantity;
        this.purchase_date = purchase_date;
        this.status = status;
    }

    @Override
    public String toString() {
        return "purchaseOrders{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", supplier_id=" + supplier_id +
                ", quantity=" + quantity +
                ", purchase_date='" + purchase_date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(String purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

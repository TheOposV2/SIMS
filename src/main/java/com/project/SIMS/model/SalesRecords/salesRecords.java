package com.project.SIMS.model.SalesRecords;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;

@Entity
public class salesRecords {
    @Id
    private int id;
    private int product_id;
    private int quantity_sold;
    private String sale_date;

    public salesRecords() {
    }

    public salesRecords(int id, int product_id, int quantity_sold, String sale_date) {
        this.id = id;
        this.product_id = product_id;
        this.quantity_sold = quantity_sold;
        this.sale_date = sale_date;
    }

    @Override
    public String toString() {
        return "salesRecords{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", quantity_sold=" + quantity_sold +
                ", sale_date='" + sale_date + '\'' +
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

    public int getQuantity_sold() {
        return quantity_sold;
    }

    public void setQuantity_sold(int quantity_sold) {
        this.quantity_sold = quantity_sold;
    }

    public String getSale_date() {
        return sale_date;
    }

    public void setSale_date(String sale_date) {
        this.sale_date = sale_date;
    }
}

package com.project.SIMS.model.Supplier;

import jakarta.persistence.*;

@Entity
@Table(name = "suppliers")
public class supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String contact_email;
    private String phone;

    public supplier(int id, String name, String contact_email, String phone) {
        this.id = id;
        this.name = name;
        this.contact_email = contact_email;
        this.phone = phone;
    }

    public supplier() {
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact_email='" + contact_email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
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

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

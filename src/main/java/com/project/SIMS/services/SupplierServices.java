package com.project.SIMS.services;

import com.project.SIMS.model.Supplier.Supplier;
import com.project.SIMS.repo.SupplierDAO;

public class SupplierServices {

    private final SupplierDAO supplierDAO;

    public SupplierServices() {
        this.supplierDAO = new SupplierDAO();
    }

    public Supplier getSupplierById(int id) {
        Supplier supplier = supplierDAO.findById(id);
        if (supplier == null) {
            throw new RuntimeException("Supplier not found with id: " + id);
        }
        return supplier;
    }

}

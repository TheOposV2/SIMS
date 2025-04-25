package com.project.SIMS.services;

import com.project.SIMS.model.Supplier;
import com.project.SIMS.repo.SupplierDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServices {

    @Autowired
    private SupplierDAO supplierDAO;
    @Autowired
    private ProductService productService;

    public Supplier getSupplierByProductId(int id) {
        Supplier supplier = supplierDAO.findById(id);
        if (supplier == null) {
            throw new RuntimeException("Supplier not found with id: " + id);
        }
        return supplier;
    }

    public Supplier getSupplierById(int id) {
        Supplier supplier = supplierDAO.findById(id);
        if (supplier == null) {
            throw new RuntimeException("Supplier not found with id: " + id);
        }
        return supplier;
    }

    public boolean supplierExist(int supplierID){
        return supplierDAO.supplierExist(supplierID);
    }

}

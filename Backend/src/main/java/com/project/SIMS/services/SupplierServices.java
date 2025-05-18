package com.project.SIMS.services;

import com.project.SIMS.exception.SupplierNotFoundException;
import com.project.SIMS.model.Product;
import com.project.SIMS.model.Supplier;
import com.project.SIMS.repo.SupplierDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
public class SupplierServices {

    @Autowired
    private SupplierDAO supplierDAO;
    @Autowired
    private ProductService productService;

    public Supplier getSupplierByProductId(int id) { //to do
        Product Product = productService.getProductById(id);
        return getSupplierById(Product.getSupplier_id());
    }

    public Supplier getSupplierById(int id) {
        Optional<Supplier> optionalSupplier = supplierDAO.findById(id);
        return optionalSupplier
                .orElseThrow(() -> new SupplierNotFoundException("Supplier not found"));

    }

    public boolean supplierExist(int supplierID){
        return supplierDAO.supplierExist(supplierID);
    }

}



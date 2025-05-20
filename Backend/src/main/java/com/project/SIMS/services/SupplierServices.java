package com.project.SIMS.services;

import com.project.SIMS.exception.SupplierNotFoundException;
import com.project.SIMS.model.Product;
import com.project.SIMS.model.Supplier;
import com.project.SIMS.repo.SupplierDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

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

    public boolean isSupplierValid(Supplier supplier){
        return( Stream.of(
                supplier.getId(),
                supplier.getName(),
                supplier.getContact_email(),
                supplier.getPhone()
        ).noneMatch(Objects::isNull));

    }


    public boolean addSupplier(Supplier supplier){
        if(supplierExist(supplier.getId())){ throw new SupplierNotFoundException("Supplier exist");} //add new exception
        if(!isSupplierValid(supplier)){ throw new SupplierNotFoundException("Suplier not found"); //Add new exception suoplier not valid
        supplierDAO.save(supplier);
        return supplierExist(supplier.getId());
    }

    public boolean updateSupplier(Supplier supplier){
        return true;
    }



}



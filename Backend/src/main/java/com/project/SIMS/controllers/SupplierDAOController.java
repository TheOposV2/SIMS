package com.project.SIMS.controllers;

import com.project.SIMS.model.Supplier;
import com.project.SIMS.services.SupplierServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/suppliers")
public class SupplierDAOController {

    @Autowired
    private SupplierServices supplierService; //best practise to let spring to create and manage

    @GetMapping("/{id}")
    public Supplier getSupplier(@PathVariable int id) {
        return supplierService.getSupplierById(id);
    }

    @GetMapping({"/item/{id}"})
    public Supplier getSupplierByProductId(@PathVariable("id") int ProductId){
        return supplierService.getSupplierByProductId(ProductId);}
    }

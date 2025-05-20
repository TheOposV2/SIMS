package com.project.SIMS.controllers;

import com.project.SIMS.model.Product;
import com.project.SIMS.model.Supplier;
import com.project.SIMS.services.SupplierServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suppliers")
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


    @PostMapping("") // Mapping POST request
    public boolean add(@RequestBody Supplier supplier){
        return supplierService.addSupplier(supplier);
    }

    @PutMapping("/{id}") //Mapping PUT request
    public boolean update(@PathVariable("id") int id,
                      @RequestBody Supplier updateSupplier){
        return supplierService.updateSupplier(updateSupplier);
    }

    }
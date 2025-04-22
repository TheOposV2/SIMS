package com.project.SIMS.controllers;

import com.project.SIMS.model.Supplier;
import com.project.SIMS.services.SupplierServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/suppliers")
public class SupplierDAOController {

    private final SupplierServices supplierService = new SupplierServices();

    @GetMapping("/{id}")
    public Supplier getSupplier(@PathVariable int id) {
        return supplierService.getSupplierById(id);
    }
}

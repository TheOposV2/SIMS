package com.project.SIMS.controllers;


import com.project.SIMS.services.Product.ProductService;
import com.project.SIMS.model.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public List<Product> getALL(){
        return productService.getALL();
    }

    @GetMapping("/{id}")
    public Product getByID(@PathVariable("id") int id){
        return productService.getProductById(id);
    }
    @PostMapping("")
    public boolean add(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @PutMapping("/{id}")
    public boolean update(@PathVariable("id") int id,
                          @RequestBody Product updatedProduct){
        return productService.updateProduct(id,updatedProduct);
    }

    @GetMapping("/low/{howMany}")
    public List<Product> lowQuantityProducts(@PathVariable("howMany") int howMany){
        return productService.lowQuantityProducts(howMany);
    }



}

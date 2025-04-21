package com.project.SIMS.controllers;


import com.project.SIMS.services.ProductService;
import com.project.SIMS.model.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Mapping to string that this is controller of endpoints
@RequestMapping("/product") // forcing that require for this controller have to start with /product path
public class ProductController {

    @Autowired // Dependency injection - connecting controller to services
    ProductService productService;

    @GetMapping("") //Mapping GET request to this path
    public List<Product> getALL(){
        return productService.getALL();
    } // function invoked when requesting this path

    @GetMapping("/{id}")
    public Product getByID(@PathVariable("id") int id){
        return productService.getProductById(id);
    }

    @PostMapping("") // Mapping POST request
    public boolean add(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/{id}") //Mapping PUT request
    public boolean update(@PathVariable("id") int id,  // Path viable that will be red from path eg. /product/1 this request with id=1
                          @RequestBody Product updatedProduct){ // request body this path is waiting for body top be put in request
        return productService.updateProduct(id,updatedProduct);
    }

    @GetMapping("/low/{howMany}")
    public List<Product> lowQuantityProducts(@PathVariable("howMany") int howMany){
        return productService.lowQuantityProducts(howMany);
    }



}

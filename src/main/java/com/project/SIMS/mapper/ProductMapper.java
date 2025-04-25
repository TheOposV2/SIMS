package com.project.SIMS.mapper;


import com.project.SIMS.model.Product;
import com.project.SIMS.model.ProductDbtO;
import com.project.SIMS.model.Supplier;
import com.project.SIMS.services.SupplierServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {


    public Product ProductBuilder(ProductDbtO productDbtO, Supplier supplier){
        Product product = new Product();

        product.setId(productDbtO.getId());
        product.setName(productDbtO.getName());
        product.setDescription(productDbtO.getDescription());
        product.setQuantity(productDbtO.getQuantity());
        product.setPrice(productDbtO.getPrice());
        product.setSupplier(supplier);

        return product;
    }

}

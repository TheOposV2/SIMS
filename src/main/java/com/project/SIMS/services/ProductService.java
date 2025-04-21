package com.project.SIMS.services;

import com.project.SIMS.exception.DataIntegrityException;
import com.project.SIMS.exception.ProductNotFoundException;
import com.project.SIMS.exception.UsedIdException;
import com.project.SIMS.model.Product.Product;
import com.project.SIMS.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


   public List<Product> getALL(){
        return productRepository.getALL();
   }

    public boolean isProductValid(Product product){
        return( Stream.of(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getQuantity(),
                product.getPrice(),
                product.getSupplier_id()
        ).noneMatch(Objects::isNull)
                && product.getPrice() > 0
                && product.getQuantity() >= 0);
    }

   public Product getProductById(int id) {
       return productRepository.getByID(id)
               .orElseThrow(() -> new ProductNotFoundException("Product not found"));
   }

   public boolean updateProduct(int id , Product updatedProduct){
       Product product = getProductById(id);
      // if(!supplierIdExist(updatedProduct.getSupplier_id())) return false; do dodania w services dla suplierów
       if(isProductValid(updatedProduct)) {
           product.setName(updatedProduct.getName());
           product.setDescription(updatedProduct.getDescription());
           product.setPrice(updatedProduct.getPrice());
           product.setQuantity(updatedProduct.getQuantity());
           product.setSupplier_id(updatedProduct.getSupplier_id());
           return productRepository.updateProduct(product);
       } else return false;
   }

   public boolean productExists(int id){
       return productRepository.productExists(id);
   }

   public boolean addProduct(Product product){
      if(productExists(product.getId())) throw new UsedIdException("Provide unique ID");
      if(!isProductValid(product)) throw new DataIntegrityException("Product not valid");
      return productRepository.addProduct(product);
   }

   public boolean deleteProduct(int id){
       if(!productExists(id)) throw new ProductNotFoundException("Product not found");
       return productRepository.deleteProduct(id);
   }

   public List<Product> lowQuantityProducts(int howManny){
       return productRepository.lowQuantityProducts(howManny);
   }

}

package com.project.SIMS.services;

import com.project.SIMS.exception.DataIntegrityException;
import com.project.SIMS.exception.ProductNotFoundException;
import com.project.SIMS.exception.UsedIdException;
import com.project.SIMS.mapper.ProductMapper;
import com.project.SIMS.model.Product;
import com.project.SIMS.model.ProductDbtO;
import com.project.SIMS.model.Supplier;
import com.project.SIMS.repo.ProductRepository;
import com.project.SIMS.repo.SupplierDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Service //Mapping for spring that this is service layer
public class ProductService {

    @Autowired
    ProductRepository productRepository; // connecting repository to services
    @Autowired
    private SupplierDAO supplierDAO;
    @Autowired
    private ProductMapper productMapper;

   // Get all records logic
   public List<Product> getALL(){
        return productRepository.getALL();
   }


   // Function to check if object is not null or don't have improper arguments
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

    // Get by id logic
   public Product getProductById(int id) {
       Optional<ProductDbtO> optionalProductDbtO = productRepository.getByID(id);

       ProductDbtO productDbtO = optionalProductDbtO.orElseThrow(
               () -> new ProductNotFoundException("Product not found"));

       Supplier supplier = supplierDAO.findById(productDbtO.getSupplier_id()); //to add optional to supplier

       return productMapper.ProductBuilder(productDbtO,supplier);
   }

   // update logic
   public boolean updateProduct(int id , Product updatedProduct){
       Product product = getProductById(id); // get product to update and invoke check if it isn't null
      if(!supplierDAO.supplierExist(updatedProduct.getSupplier_id())) return false;
      if(isProductValid(updatedProduct)) { //if passed body is proper update product in db
           product.setName(updatedProduct.getName());
           product.setDescription(updatedProduct.getDescription());
           product.setPrice(updatedProduct.getPrice());
           product.setQuantity(updatedProduct.getQuantity());
           product.setSupplier_id(updatedProduct.getSupplier_id());
           return productRepository.updateProduct(product);
       } else return false; // fi not return false
   }

   //check if product whit id exist necessary for some functions when getting object from db is waste of memory
   public boolean productExists(int id){
       return productRepository.productExists(id);
   }


   public boolean addProduct(Product product){
      if(productExists(product.getId())) throw new UsedIdException("Provide unique ID"); // check if id is unique
      if(!isProductValid(product)) throw new DataIntegrityException("Product not valid"); // check if provided is valid
      return productRepository.addProduct(product); // return true or false if something goes wrong
   }

   public boolean deleteProduct(int id){
       if(!productExists(id)) throw new ProductNotFoundException("Product not found"); //check if product to delete exist
       return productRepository.deleteProduct(id);
   }


   public List<Product> lowQuantityProducts(int howManny){
       return productRepository.lowQuantityProducts(howManny); //return list of items with quantity =< howManny
   }

}

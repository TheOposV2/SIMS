package com.project.SIMS.repo;

import com.project.SIMS.model.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository //Maping for spring that this is repository
public class ProductRepository {

    @Autowired
    JdbcTemplate jdbcTemplate; // using jdbc to connect to db

    public List<Product> getALL(){
        return jdbcTemplate.query("SELECT * FROM products"
                ,BeanPropertyRowMapper.newInstance(Product.class));
    }

    public Product getByName(String name){
        return jdbcTemplate.queryForObject("SELECT * FROM products WHERE name = ?"
                ,BeanPropertyRowMapper.newInstance(Product.class),name);
    }


    public Optional<Product> getByID(int id){
        try {
          Product product = jdbcTemplate.queryForObject("SELECT * FROM products WHERE id = ?"
                 ,BeanPropertyRowMapper.newInstance(Product.class), id);
            return Optional.of(product); // returning OPTIONAL object because record can be empty or not exist
        }catch (EmptyResultDataAccessException e){
            System.out.println("Element don't exist");
            return Optional.empty();
        }

    }

    public boolean productExists(int id) {
        String sql = "SELECT COUNT(*) FROM products WHERE id = ?"; // COUNT(*) returns number of unique records
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }

    public boolean addProduct(Product product){
        try {
            jdbcTemplate.update("INSERT INTO products(id, name, description, quantity," +
                            " price, supplier_id) VALUES(?, ?, ?, ?, ?, ?)",
                    product.getId(), product.getName(), product.getDescription()
                    , product.getQuantity(), product.getPrice(), product.getSupplier_id());
            return true;
        }catch (DataIntegrityViolationException e){
            System.out.println("Add proper list of elements");
        }catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean updateProduct(Product product){ //return tru to give feedback if action on db side was done
        try {
            jdbcTemplate.update("UPDATE products SET" +
                            " name = ? ,description = ? ,quantity = ? " +
                            ",price = ? ,supplier_id = ? WHERE id = ?",
                    product.getName(), product.getDescription(),
                    product.getQuantity(), product.getPrice(),
                    product.getSupplier_id() ,product.getId());
            return true;
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
            System.out.println("Add proper list of elements");
        }catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean deleteProduct(int id){
        try {
            jdbcTemplate.update("DELETE FROM movie WHERE id=?", id);
            return true;
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> lowQuantityProducts(int howManny){
        try {
             return jdbcTemplate.query("SELECT * FROM products WHERE quantity =< ?"
                    ,new BeanPropertyRowMapper<>(Product.class), howManny);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

}

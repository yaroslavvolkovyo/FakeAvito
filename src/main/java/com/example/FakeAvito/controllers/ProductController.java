package com.example.FakeAvito.controllers;


import com.example.FakeAvito.dto.ProductRequestDTO;
import com.example.FakeAvito.model.Product;
import com.example.FakeAvito.service.AuthorService;
import com.example.FakeAvito.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    ProductService productService;
    AuthorService authorService;
    @Autowired
    public ProductController(ProductService productService, AuthorService authorService) {
        this.productService = productService;
        this.authorService = authorService;
    }

    @PostMapping("/save")
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequestDTO requestDTO) {
        Product product = productService.createProduct(requestDTO); // Передаем DTO
        return ResponseEntity.ok(product);
    }

//    @PostMapping("/save")
//    public void save(@RequestBody Product product) {
//        productService.save(product);
//    }

    @GetMapping("/get")
    public List<Product> getAll() {
        return productService.findAll();
    }
//id берется из url
    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.findById(id);
    }

//    @GetMapping("/get/{name}")
//    public Optional<Product> getProductByName(@PathVariable String name) {
//        return productService.findByName(name);
//    }

    @GetMapping("/get/search")
    public Optional<Product> getProductByNamev2(@RequestParam String name){
        return productService.findByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try{
            productService.deleteById(id);
            return ResponseEntity.ok("Product with id " + id + " deleted successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with id " + id + " not found");
        }
    }

    @DeleteMapping("/deleteByName")//в url ?name = name
    public ResponseEntity<String> deleteProductByName(@RequestParam String name) {
        try {
            productService.deleteByName(name);
            return ResponseEntity.ok("Product with name " + name + " deleted successfully.");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}

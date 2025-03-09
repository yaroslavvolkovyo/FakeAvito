package com.example.FakeAvito.service;

import com.example.FakeAvito.dto.ProductRequestDTO;
import com.example.FakeAvito.model.Author;
import com.example.FakeAvito.model.Product;
import com.example.FakeAvito.repository.AuthorRepository;
import com.example.FakeAvito.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {



    ProductRepository productRepository;
    AuthorRepository authorRepository;
    @Autowired
    public ProductService(ProductRepository productRepository, AuthorRepository authorRepository) {
        this.productRepository = productRepository;
        this.authorRepository = authorRepository;
    }



//    public void save(Product product) {
//        productRepository.save(product);
//    }

    @Transactional
    public Product createProduct(ProductRequestDTO requestDTO) {
        Author author = authorRepository.findById(requestDTO.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Product product = new Product();
        product.setName(requestDTO.getName());
        product.setPrice(requestDTO.getPrice());
        product.setAuthor(author);

        author.addProduct(product); // Добавляем продукт к автору
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Optional<Product> findByName(String name) {
        long count = productRepository.countByName(name);
        if (count == 0) {
            throw new RuntimeException("Product with name " + name + " not found");
        }
        return productRepository.findByName(name);
    }

    public void deleteById(Long id) {
        long count = productRepository.countById(id);
        if(count == 0){
            throw new RuntimeException("Product with id " + id + " not found");
        }
        productRepository.deleteById(id);
    }

    @Transactional
    public void deleteByName(String name) {
        long count = productRepository.countByName(name);
        if (count == 0) {
            throw new RuntimeException("Product with name " + name + " not found");
        }
        productRepository.deleteByName(name);
    }



}

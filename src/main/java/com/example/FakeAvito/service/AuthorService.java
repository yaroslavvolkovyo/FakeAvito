package com.example.FakeAvito.service;

import com.example.FakeAvito.model.Author;
import com.example.FakeAvito.model.Product;
import com.example.FakeAvito.repository.AuthorRepository;
import com.example.FakeAvito.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    ProductRepository productRepository;
    public AuthorService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    ProductService productService;
    public AuthorService(ProductService productService) {
        this.productService = productService;
    }

    AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author save(Author author) {
        authorRepository.save(author);
        return author;
    }

    public void deleteById(Long id) {
        long count = authorRepository.countById(id);
        if (count == 0) {
            throw new RuntimeException("No author found with id: " + id);
        }
        authorRepository.deleteById(id);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

}

package com.example.FakeAvito.controllers;

import com.example.FakeAvito.model.Author;
import com.example.FakeAvito.model.Product;
import com.example.FakeAvito.repository.AuthorRepository;
import com.example.FakeAvito.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reg")
@Validated
public class AuthorController {


    Product product;



    AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/newAuthor")
    public void createAuthor(@Valid @RequestBody Author author) {
        authorService.save(author);
    }
//id берется из url
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id) {
        try{
            authorService.deleteById(id);
            return ResponseEntity.ok("Author with id " + id + " deleted successfully.");
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

    }
}

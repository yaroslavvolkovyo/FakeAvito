package com.example.FakeAvito.repository;

import com.example.FakeAvito.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    long countById(Long id);
}

package com.example.FakeAvito.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Поле имя, не может быть пустым")
    @Size(min = 3, max = 50, message = "Имя должно содержать от 3 до 50 символов")
    private String name;

    @NotBlank(message = "Поле Email, не может быть пустым")
    @Email(message = "Неверный формат Email")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "Поле пароль должно содержать символы (минмально - 6)")
    @Size(min = 6, max = 100, message = "Пароль должен содержать минимум 6 символов")
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

    public Author(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void addProduct(Product product) {
        products.add(product);
        product.setAuthor(this);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.setAuthor(null);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Author() {}


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

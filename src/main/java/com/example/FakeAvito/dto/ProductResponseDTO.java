package com.example.FakeAvito.dto;

import com.example.FakeAvito.model.Product;

public class ProductResponseDTO {
    private Long id;
    private String name;
    private String description;
    private int price;
    private String authorName;
    private String city;

    public ProductResponseDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.city = product.getCity();
        if(product.getAuthor() != null) {
            this.authorName = product.getAuthor().getName();
        }else {
            this.authorName = "Чувырло без имени";
        }

    }

    public ProductResponseDTO() {
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

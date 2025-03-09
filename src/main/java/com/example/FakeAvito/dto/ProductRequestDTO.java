package com.example.FakeAvito.dto;

public class ProductRequestDTO {
    private String name;
    private String description;
    private int price;
    private Long authorId;
    private String city;

    public ProductRequestDTO() {
    }

    public ProductRequestDTO(Long authorId, String city, String description, String name, int price) {
        this.authorId = authorId;
        this.city = city;
        this.description = description;
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}

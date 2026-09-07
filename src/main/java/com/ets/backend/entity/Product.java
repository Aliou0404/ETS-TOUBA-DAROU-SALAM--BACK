package com.ets.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String brand;

    @Column(nullable = false)
    private String category;

    private Double price;

    @Column(columnDefinition = "TEXT")
    private String image;

    private String emoji;

    @Column(nullable = false)
    private Boolean available = true;

    public Product() {
    }

    public Product(
            String name,
            String brand,
            String category,
            Double price,
            String image,
            String emoji,
            Boolean available
    ) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.image = image;
        this.emoji = emoji;
        this.available = available;
    }

}
package com.example.demo.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private int qty;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private int price;
}

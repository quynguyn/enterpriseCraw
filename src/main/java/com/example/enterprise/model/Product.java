package com.example.enterprise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    private String _id;

    private String description;
    private String name;
    private String image;

    private int price;
    private String vendor;
}

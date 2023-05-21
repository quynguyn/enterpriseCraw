package com.example.enterpriseCraw.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "compare")
public class Product {

    @Id
    private String _id;

    private String name;

    @Column(name = "component")
    private String component;

    private int price;
}

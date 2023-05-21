package com.example.enterprise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    private String _id;
    private String activity;
    private String orderAddress;
    private String ordererName;
    private String productList;
}

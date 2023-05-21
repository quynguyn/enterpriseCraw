package com.example.enterpriseCraw.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "gearvn")
public class GearVn {

    @Id
    private String _id;

    private String fullName;
    private String shortName;

    @Column(name = "component")
    private String Component;
    private String Img;
    private int Price;
}

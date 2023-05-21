package com.example.enterprise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class Account {

    @Id
    private String _id;

    private String address;
    private String businessaddress;
    private String businessname;

    private String name;
    private String password;
    private String profilePicture;
    private String type;
    private String username;


}

package com.example.enterpriseCraw.controller;

import com.example.enterpriseCraw.model.GearVn;
import com.example.enterpriseCraw.repo.GearVnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class GearVnController {

    @Autowired
    GearVnRepo gearVnRepo;

    @GetMapping
    public List<GearVn> getAll(){
        return gearVnRepo.findAll();
    }
}

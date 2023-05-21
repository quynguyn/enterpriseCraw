package com.example.enterpriseCraw.controller;

import com.example.enterpriseCraw.model.GearVn;
import com.example.enterpriseCraw.repo.GearVnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping()
public class GearVnController {

    @Autowired
    GearVnRepo gearVnRepo;

    @GetMapping("/gearVN")
    public List<GearVn> getAll(){
        return gearVnRepo.findAll();
    }

    @GetMapping("/{component}")
    public List<GearVn> getProductsByComponent(@PathVariable String component) {
        return gearVnRepo.findByComponent(component);
    }


    @GetMapping("/{id}")
    public GearVn getGearVbByID(@PathVariable String id) {
        Optional<GearVn> gearVnOptional= gearVnRepo.findById(id);
        return gearVnOptional.orElse(null);
    }
}

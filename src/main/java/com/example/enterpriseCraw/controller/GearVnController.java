package com.example.enterpriseCraw.controller;

import com.example.enterpriseCraw.model.GearVn;
import com.example.enterpriseCraw.repo.GearVnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class GearVnController {

    @Autowired
    GearVnRepo gearVnRepo;

    @GetMapping("/gearVN")
    public List<GearVn> getAll(){
        return gearVnRepo.findAll();
    }

    @GetMapping("/category/{component}")
    public String getProductsByComponent(@PathVariable String component, Model model) {
       List<GearVn> componentList = gearVnRepo.findByComponent(component);
       model.addAttribute("product",componentList);
       return "category";
    }


//    @GetMapping("/{id}")
//    public List<GearVn> getProductsByComponent(@ String component) {
//        List <GearVn> componentList = gearVnRepo.findByComponent(component);
//        model.addAttribute("products", componentList);
//        return "product-list";
//    }


}

package com.example.PetClinic.controllers;

import com.example.PetClinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {



    @RequestMapping({"/vets", "vets/index", "/vets/index.html"})
    public  String listVets() {

        return "vets/index";
    }
}

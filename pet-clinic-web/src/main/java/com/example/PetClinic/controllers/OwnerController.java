package com.example.PetClinic.controllers;

import com.example.PetClinic.model.Owner;
import com.example.PetClinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public  String listOwners(Model model) {

        //"owners" is a mapping property that out html page is used to query data
        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }
}

package com.example.PetClinic.controllers;

import com.example.PetClinic.model.Owner;
import com.example.PetClinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.Null;
import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public  String listOwners(Model model) {

        //"owners" is a mapping property that out html page is used to query data
        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners(Model model)
    {
        model.addAttribute("owner", new Owner());
        return "owners/findOwners";
    }

    @GetMapping("/owners")
    public String processFindForm(Owner owner, BindingResult result, Model model){
        //allow parameters GET request for /owners to return all records
        if (owner.getLastName() == null){
            owner.setLastName(""); //empty string signifies broadest possible search
        }

        //find owners by last name
        List<Owner> results = ownerService.findAllByLastNameLike( "%"+ owner.getLastName() +"%");

        if (results.isEmpty()){
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (results.size() == 1){
            // 1 owner found
            owner = results.iterator().next();
        } else {
            // multiple owners found
            model.addAttribute("selections", results);
            return "owners/ownerList";
        }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId)
    {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }
}

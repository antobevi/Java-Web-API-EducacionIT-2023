package com.antobevi.JavaWebAPIEducacionIT2023.controller;

import com.antobevi.JavaWebAPIEducacionIT2023.model.Pet;
import com.antobevi.JavaWebAPIEducacionIT2023.service.OwnerService;
import com.antobevi.JavaWebAPIEducacionIT2023.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/pets")
public class PetViewController {
    @Autowired
    private PetService petService;
    @Autowired
    private OwnerService ownerService;

    @GetMapping("/list")
    public String listPets(Model model) {
        List<Pet> pets = petService.listPets();
        model.addAttribute("pets", pets);

        return "list-pets";
    }

    @GetMapping("/form-new-pet")
    public String getFormNewPet(Model model) {
        model.addAttribute("owners", ownerService.listOwners());
        //model.addAttribute("pet", new Pet());

        return "form-new-pet";
    }

    @PostMapping("/add")
    public String addPet(Pet pet, @RequestParam Long ownerId) {
        petService.savePet(pet, ownerId);

        return "redirect:/api/pets/list";
    }

    // TODO: Update pet

    // TODO: Delete pet

}

package com.antobevi.JavaWebAPIEducacionIT2023.service;

import com.antobevi.JavaWebAPIEducacionIT2023.model.Owner;
import com.antobevi.JavaWebAPIEducacionIT2023.model.Pet;
import com.antobevi.JavaWebAPIEducacionIT2023.repository.OwnersRepository;
import com.antobevi.JavaWebAPIEducacionIT2023.repository.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    @Autowired
    private PetsRepository petsRepository;
    @Autowired
    private OwnersRepository ownersRepository; // Antes de buscar una mascota, necesitamos buscar el dueño

    public List<Pet> listPets() {
        return petsRepository.findAll();
    }

    public void savePet(Pet pet, Long ownerId) {
        // Buscamos el dueño y si no lo encuentra tira una excepcion
        Owner owner = ownersRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("Owner not found."));
        pet.setOwner(owner);
        petsRepository.save(pet);
    }

}

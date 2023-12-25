package com.antobevi.JavaWebAPIEducacionIT2023.service;

import com.antobevi.JavaWebAPIEducacionIT2023.model.Owner;
import com.antobevi.JavaWebAPIEducacionIT2023.model.Pet;
import com.antobevi.JavaWebAPIEducacionIT2023.repository.OwnersRepository;
import com.antobevi.JavaWebAPIEducacionIT2023.repository.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetsRepository petsRepository;
    @Autowired
    private OwnersRepository ownersRepository; // Antes de buscar una mascota, necesitamos buscar el dueño

    public List<Pet> listPets() {
        //Sort sortBy = Sort.by(Sort.Direction.DESC, "name").ignoreCase();
        return petsRepository.findAllOrderByNameIgnoreCaseDesc();
    }

    public Pet savePet(Pet pet, Long ownerId) {
        // Buscamos el dueño y si no lo encuentra tira una excepcion
        Owner owner = ownersRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("Owner not found."));
        pet.setOwner(owner);
        return petsRepository.save(pet);
    }

    // Operaciones CRUD
    public void deletePet(Long id) {
        // Optional declara un espacio de memoria que puede estar presente o no, si encontramos el dato lo almacena y si no, queda vacio.
        Optional<Pet> petOptional =  petsRepository.findById(id);

        if(petOptional.isPresent()) {
            petsRepository.delete(petOptional.get());
        } else {
            throw new RuntimeException("Pet not found."); // Arrojamos excepcion
        }
    }

    public void updatePet(Long id, Pet updatedPet) {
        Optional<Pet> petOptional =  petsRepository.findById(id);

        if(petOptional.isPresent()) {
            Pet pet = petOptional.get();
            pet.setName(updatedPet.getName());
            pet.setAge(updatedPet.getAge());
            pet.setSpecies(updatedPet.getSpecies()); // Se puede omitir ya que la especie no es algo que cambie, salvo que se haya cargado por error
            pet.setOwner(updatedPet.getOwner());

            petsRepository.save(pet); // El framework pisa lo que ya esta cargado, no lo duplica
        } else {
            throw new RuntimeException("Pet to update not found."); // Arrojamos excepcion
        }
    }

    public Pet getPetById(Long id) {
        return petsRepository.findById(id).orElseThrow(() -> new RuntimeException("Pet not found."));
    }

}

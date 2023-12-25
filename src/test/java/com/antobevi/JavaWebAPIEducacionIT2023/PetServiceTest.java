package com.antobevi.JavaWebAPIEducacionIT2023;

import com.antobevi.JavaWebAPIEducacionIT2023.model.Owner;
import com.antobevi.JavaWebAPIEducacionIT2023.model.Pet;
import com.antobevi.JavaWebAPIEducacionIT2023.service.OwnerService;
import com.antobevi.JavaWebAPIEducacionIT2023.service.PetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PetServiceTest {
    @Autowired
    private PetService petService;
    @Autowired
    private OwnerService ownerService;
    /*
    @Test
    public void savePetTest() {
        Owner owner = new Owner();
        owner.setName("Antonella");
        owner.setSurname("Bevilacqua");
        owner.setAddress("marañon 1124");

        Owner savedOwner = ownerService.saveOwner(owner);

        Pet pet = new Pet();
        pet.setName("Morita");
        pet.setAge(10);
        pet.setSpecies("Perro");
        pet.setOwner(savedOwner);

        Pet savedPet = petService.savePet(pet, savedOwner.getId());

        assertNotNull(savedPet.getId());
        assertEquals("Morita", savedPet.getName());
        assertEquals(10, savedPet.getAge());
        assertEquals("Perro", savedPet.getSpecies());
        assertEquals(savedOwner.getId(), savedPet.getOwner().getId());
    }

    @Test
    public void listPetsTest() {
        List<Pet> pets = petService.listPets();

        assertTrue(pets.size() > 0);
    }

    @Test
    public void getPetByIdTest() {
        Long petId = 1L;
        Pet pet = petService.getPetById(petId);

        assertNotNull(pet);
        assertEquals(petId, pet.getId());
    }

    @Test
    public void updatePetTest() {
        Long petId = 1L;
        Pet originalPet = petService.getPetById(petId);

        Pet petForUpdate = new Pet();
        petForUpdate.setName("Morita");
        petForUpdate.setAge(10);
        petForUpdate.setSpecies("Perro");

        petService.updatePet(originalPet.getId(), petForUpdate);

        Pet updatedPet = petService.getPetById(petId);

        assertEquals(petForUpdate.getName(), updatedPet.getName());
        assertEquals(petForUpdate.getAge(), updatedPet.getAge());
        assertEquals(petForUpdate.getSpecies(), updatedPet.getSpecies());
    }
    */
}

package com.antobevi.JavaWebAPIEducacionIT2023.repository;

import com.antobevi.JavaWebAPIEducacionIT2023.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetsRepository extends JpaRepository<Pet, Long> {

    Optional<Pet> findByPetName(String name);

}

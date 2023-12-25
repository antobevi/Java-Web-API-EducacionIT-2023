package com.antobevi.JavaWebAPIEducacionIT2023.repository;

import com.antobevi.JavaWebAPIEducacionIT2023.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetsRepository extends JpaRepository<Pet, Long> {

    Optional<Pet> findByName(String name);

    @Query("SELECT m FROM Pet m ORDER BY LOWER(m.name) ASC")
    List<Pet> findAllOrderByNameIgnoreCaseDesc();

}

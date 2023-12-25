package com.antobevi.JavaWebAPIEducacionIT2023.repository;

import com.antobevi.JavaWebAPIEducacionIT2023.model.WebAppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<WebAppUser, Long> {

    // La operacion SAVE viene por defecto
    Optional<WebAppUser> findByName(String name);

}

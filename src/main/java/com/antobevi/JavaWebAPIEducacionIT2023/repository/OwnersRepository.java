package com.antobevi.JavaWebAPIEducacionIT2023.repository;

import com.antobevi.JavaWebAPIEducacionIT2023.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnersRepository extends JpaRepository<Owner, Long> { // Se pasa Clase, Id por param.
    // TODO: Implementar metodos personalizados de busqueda para OwnersRepository
}

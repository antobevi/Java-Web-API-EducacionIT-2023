package com.antobevi.JavaWebAPIEducacionIT2023.service;

import com.antobevi.JavaWebAPIEducacionIT2023.model.Owner;
import com.antobevi.JavaWebAPIEducacionIT2023.repository.OwnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
En esta capa Service es donde ponemos toda la logica de negocio, como por ejemplo,
listar todos los dueños con mas de 2 mascotas.
*/

@Service
public class OwnerService {
    @Autowired // En lugar de hacer un new, usamos el Autowired que nos permite instanciarlo.
    private OwnersRepository ownersRepository;

    public List<Owner> listOwners() {
        return ownersRepository.findAll(); // Metodo heredado que encuentra todas las entidades usando la interfaz
    }

    public Owner saveOwner(Owner owner) {
        return ownersRepository.save(owner);
    }

}

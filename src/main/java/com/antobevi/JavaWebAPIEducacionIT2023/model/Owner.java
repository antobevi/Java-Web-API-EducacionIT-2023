package com.antobevi.JavaWebAPIEducacionIT2023.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotBlank(message = "Se debe ingresar un nombre.")
    private String name;
    @NotBlank(message = "Se debe ingresar un apellido.")
    private String surname;
    @NotBlank(message = "Debe tener un direcci//u00F3n.")
    private String address; // TODO: Deberia ser una clase

    public Owner() {} //Constructor vacio que usa la libreria

    public Owner(String name, String surname, String adress) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    // Los setters tambien los requiere la libreria
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

package com.antobevi.JavaWebAPIEducacionIT2023.model;

import jakarta.persistence.*;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Integer age;
    private String name;
    private String species; // especie: perro, gato, etc.
    @ManyToOne
    private Owner owner;

    public Pet(Integer age, String name, String species, Owner owner) {
        this.age = age;
        this.name = name;
        this.species = species;
        this.owner = owner;
    }

    public Pet() {} // Constructor vacio

    public Long getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

}

package com.antobevi.JavaWebAPIEducacionIT2023.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Data // LOMBOK provee toString, equals, hashcode, getters y setters (me ahorra codigo)
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotEmpty(message = "Se debe ingresar una edad.")
    private Integer age;
    @NotBlank(message = "Se debe ingresar un nombre.")
    private String name;
    @NotBlank(message = "Se debe ingresar la especie.")
    private String species; // especie: perro, gato, etc.
    @ManyToOne
    @Min(value = 0, message = "La edad debe estar entre 0 y 25 años.")
    @Max(value = 25, message = "La edad debe estar entre 0 y 25 años.")
    // NotEmpty y NotBlank se usa solo con Strings
    private Owner owner;

    public Pet(Integer age, String name, String species, Owner owner) {
        this.age = age;
        this.name = name;
        this.species = species;
        this.owner = owner;
    }

    public Pet() {} // Constructor vacio

}

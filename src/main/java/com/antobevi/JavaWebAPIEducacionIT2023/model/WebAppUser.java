package com.antobevi.JavaWebAPIEducacionIT2023.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WebAppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotBlank(message = "Se debe ingresar un nombre.")
    private String name;
    @NotBlank(message = "Se debe ingresar un apellido.")
    private String surname;
    @NotBlank(message = "Se debe ingresar un nombre de usuario.")
    private String username;
    @NotBlank(message = "Se debe ingresar una contraseña.")
    private String password;

    public String getUsername() {
        return username;
    }

}

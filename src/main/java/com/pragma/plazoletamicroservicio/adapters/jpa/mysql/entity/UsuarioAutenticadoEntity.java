package com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioAutenticadoEntity {

    @Id
    private Long id;
    private String token;
    private String bearer = "Bearer";
    private String nombreUsuario;






}

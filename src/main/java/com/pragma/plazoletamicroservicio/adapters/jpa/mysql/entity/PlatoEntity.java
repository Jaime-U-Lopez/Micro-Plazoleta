package com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity;


import com.pragma.plazoletamicroservicio.domain.model.Pedido;
import com.pragma.plazoletamicroservicio.domain.model.Plato;
import com.pragma.plazoletamicroservicio.domain.model.Restaurante;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "plato")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlatoEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Long precio;
    private String descripcion;
    private String urlImagen;
    private String categoria;



    @ManyToOne
    private RestauranteEntity restauranteEntity;

    private boolean estado= true;



}

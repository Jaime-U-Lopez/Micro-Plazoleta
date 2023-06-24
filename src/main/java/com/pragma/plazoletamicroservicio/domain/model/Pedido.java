package com.pragma.plazoletamicroservicio.domain.model;

import java.util.List;
import java.util.Map;

public class Pedido {


    private Long id;

    private Restaurante restaurante;

    private List<Plato> platos;
    private Map<Plato, Integer> cantidadPorPlato;
    private String estado;

    public Pedido(Long id, Restaurante restaurante, List<Plato> platos, Map<Plato, Integer> cantidadPorPlato, String estado) {
        this.id = id;
        this.restaurante = restaurante;
        this.platos = platos;
        this.cantidadPorPlato = cantidadPorPlato;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public List<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(List<Plato> platos) {
        this.platos = platos;
    }

    public Map<Plato, Integer> getCantidadPorPlato() {
        return cantidadPorPlato;
    }

    public void setCantidadPorPlato(Map<Plato, Integer> cantidadPorPlato) {
        this.cantidadPorPlato = cantidadPorPlato;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

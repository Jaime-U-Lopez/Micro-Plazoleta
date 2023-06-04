package com.pragma.plazoletamicroservicio.domain.model;

import java.util.List;

public class Pedido {


    private Long id;

    private Restaurante restaurante;
    private Plato plato;
    private int cantidad;
    private String estado= "pendiente";

    private List<Pedido> listaPedidos;

    public Pedido(Long id, Restaurante restaurante, Plato plato, int cantidad, String estado, List<Pedido> listaPedidos) {
        this.id = id;
        this.restaurante = restaurante;
        this.plato = plato;
        this.cantidad = cantidad;
        this.estado = estado;
        this.listaPedidos = listaPedidos;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Plato getPlato() {
        return plato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
}

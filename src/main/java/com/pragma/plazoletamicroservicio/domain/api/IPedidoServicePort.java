package com.pragma.plazoletamicroservicio.domain.api;

import com.pragma.plazoletamicroservicio.domain.model.Pedido;
import com.pragma.plazoletamicroservicio.domain.model.Plato;

import java.util.List;

public interface IPedidoServicePort {

    void savePedido(Pedido pedido);
    void deletePedido(Long id);
    void updatePedido(Pedido pedido);

    Pedido getPedido(Long id);

    List<Pedido> getAllPedido();


}

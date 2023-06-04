package com.pragma.plazoletamicroservicio.domain.spi;

import com.pragma.plazoletamicroservicio.domain.model.Pedido;
import com.pragma.plazoletamicroservicio.domain.model.Plato;

import java.util.List;

public interface IPedidoPersistenciaPort {

    void savePedido(Pedido pedido);

    void updatePedido(Pedido pedido);

    void deletePedido(Long id);

    Pedido getPedido(Long id);

    List<Pedido> getAllPedido();



}

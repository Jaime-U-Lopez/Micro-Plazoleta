package com.pragma.plazoletamicroservicio.adapters.http.dto.response;

import com.pragma.plazoletamicroservicio.domain.model.Pedido;
import com.pragma.plazoletamicroservicio.domain.model.Plato;
import com.pragma.plazoletamicroservicio.domain.model.Restaurante;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@AllArgsConstructor
@Getter
public class PedidoResponseDto {

 private Restaurante restaurante;
 private Plato plato;
 private int cantidad;
 private String estado= "pendiente";

 private List<Pedido> listaPedidos;


}

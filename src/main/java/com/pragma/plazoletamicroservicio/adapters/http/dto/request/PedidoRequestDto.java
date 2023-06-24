package com.pragma.plazoletamicroservicio.adapters.http.dto.request;

import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.PlatoEntity;
import com.pragma.plazoletamicroservicio.domain.model.Pedido;
import com.pragma.plazoletamicroservicio.domain.model.Plato;
import com.pragma.plazoletamicroservicio.domain.model.Restaurante;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoRequestDto {


    private  String  clienteEmail ;
    private  Long  IdRestaurante ;
    private List<PlatoEntity> platos;

    private Map<Plato, Integer> cantidadPorPlato;

    @NotBlank
    private String estado= "pendiente";




}

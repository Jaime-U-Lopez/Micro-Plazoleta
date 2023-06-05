package com.pragma.plazoletamicroservicio.adapters.http.dto.request;

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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoRequestDto {



    private  Long  IdRestaurante ;
    private  Long  idPlato ;

    @Positive(message = "El cantidad debe ser positivo")
    private int cantidad;

    @NotBlank
    private String estado= "pendiente";


    private List<Pedido> listaPedidos;





}

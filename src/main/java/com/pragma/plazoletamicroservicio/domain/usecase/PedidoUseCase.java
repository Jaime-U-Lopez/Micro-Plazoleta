package com.pragma.plazoletamicroservicio.domain.usecase;

import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.PedidoEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.PlatoEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.RestauranteEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IPedidoRepository;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IPlatoRepository;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IRestauranteRepository;
import com.pragma.plazoletamicroservicio.domain.api.IPedidoServicePort;
import com.pragma.plazoletamicroservicio.domain.api.IPlatoServicePort;
import com.pragma.plazoletamicroservicio.domain.model.Pedido;
import com.pragma.plazoletamicroservicio.domain.model.Plato;
import com.pragma.plazoletamicroservicio.domain.spi.IPedidoPersistenciaPort;
import com.pragma.plazoletamicroservicio.domain.spi.IPlatoPersistenciaPort;

import java.util.List;

public class PedidoUseCase implements IPedidoServicePort {



    private final IPedidoPersistenciaPort pedidoPersistenciaPort;
    private final IPedidoRepository pedidoRepository;
    private final PedidoEntityMapper pedidoEntityMapper;

/*


    private final IPlatoRepository platoRepository;
    private final IRestauranteRepository restauranteRepository;
    private final RestauranteEntityMapper restauranteEntityMapper;
    private final PlatoEntityMapper platoEntityMapper;

 */

    public PedidoUseCase(IPedidoPersistenciaPort pedidoPersistenciaPort, IPedidoRepository pedidoRepository, PedidoEntityMapper pedidoEntityMapper) {
        this.pedidoPersistenciaPort = pedidoPersistenciaPort;
        this.pedidoRepository = pedidoRepository;
        this.pedidoEntityMapper = pedidoEntityMapper;
    }

    @Override
    public void savePedido(Pedido pedido) {



        pedidoPersistenciaPort.savePedido(pedido);



    }

    @Override
    public void deletePedido(Long id) {

        pedidoPersistenciaPort.deletePedido(id);

    }

    @Override
    public void updatePedido(Pedido pedido) {

        pedidoPersistenciaPort.updatePedido(pedido);
    }

    @Override
    public Pedido getPedido(Long id) {
        return pedidoPersistenciaPort.getPedido(id);
    }

    @Override
    public List<Pedido > getAllPedido() {


        return pedidoPersistenciaPort.getAllPedido();
    }
}

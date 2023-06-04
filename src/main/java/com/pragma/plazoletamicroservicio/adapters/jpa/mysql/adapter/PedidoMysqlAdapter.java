package com.pragma.plazoletamicroservicio.adapters.jpa.mysql.adapter;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.PedidoEntity;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.PlatoEntity;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.exceptions.PlatoException;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.PedidoEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.PlatoEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IPedidoRepository;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IPlatoRepository;
import com.pragma.plazoletamicroservicio.configuration.Constants;
import com.pragma.plazoletamicroservicio.domain.model.Pedido;
import com.pragma.plazoletamicroservicio.domain.model.Plato;
import com.pragma.plazoletamicroservicio.domain.spi.IPedidoPersistenciaPort;
import com.pragma.plazoletamicroservicio.domain.spi.IPlatoPersistenciaPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class PedidoMysqlAdapter implements IPedidoPersistenciaPort {


    private IPedidoRepository pedidoRepository;
    private PedidoEntityMapper pedidoEntityMapper;

    public PedidoMysqlAdapter(IPedidoRepository pedidoRepository, PedidoEntityMapper pedidoEntityMapper) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoEntityMapper = pedidoEntityMapper;
    }







    @Override
    public void savePedido(Pedido pedido) {
        this.pedidoRepository.save(pedidoEntityMapper.pedidoToPedidoEntity(pedido));


    }

    @Override
    public void updatePedido(Pedido pedido) {

        if(pedidoRepository.findById(pedido.getId()).isPresent()){
            throw new PlatoException(Constants.PLATO_YA_EXITE);
        }

        pedidoEntityMapper.pedidoToPedidoEntity(pedido);

        this.pedidoRepository.saveAndFlush(pedidoEntityMapper.pedidoToPedidoEntity(pedido));


    }

    @Override
    public void deletePedido(Long id) {

        Optional<PedidoEntity>  pedido=  pedidoRepository.findById(id);
        if(!pedido.isPresent()){
            throw new PlatoException(Constants.PLATO_NO_EXITE);
        }
        this.pedidoRepository.delete(pedido.get());

    }

    @Override
    public Pedido getPedido(Long id) {
        Optional<PedidoEntity> pedidoEntity = pedidoRepository.findById(id);
        if(!pedidoEntity.isPresent()){
            throw new PlatoException(Constants.PLATO_NO_EXITE);
        }
        return pedidoEntityMapper.pedidoEntityToPedido(pedidoEntity.get());
    }

    @Override
    public List<Pedido> getAllPedido() {


        List<PedidoEntity>  pedidoEntityList = pedidoRepository.findAll();
        if(pedidoEntityList.size()==0){
            throw new PlatoException(Constants.LISTA_PLATO_NO_VACIA);

        }
        return pedidoEntityMapper.toPedidoList(pedidoEntityList);

    }
}

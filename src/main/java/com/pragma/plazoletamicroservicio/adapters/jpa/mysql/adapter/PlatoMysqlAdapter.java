package com.pragma.plazoletamicroservicio.adapters.jpa.mysql.adapter;
import com.pragma.plazoletamicroservicio.adapters.http.exceptions.PlatoNoExiste;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.PlatoEntity;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.exceptions.PlatoException;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.PlatoEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IPlatoRepository;
import com.pragma.plazoletamicroservicio.configuration.Constants;
import com.pragma.plazoletamicroservicio.domain.model.Plato;
import com.pragma.plazoletamicroservicio.domain.spi.IPlatoPersistenciaPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class PlatoMysqlAdapter  implements IPlatoPersistenciaPort {


    private IPlatoRepository platoRepository;
    private PlatoEntityMapper platoEntityMapper;


    public PlatoMysqlAdapter(IPlatoRepository platoRepository, PlatoEntityMapper platoEntityMapper) {
        this.platoRepository = platoRepository;
        this.platoEntityMapper = platoEntityMapper;
    }

    @Override
    public void savePlato(PlatoEntity platoEntity ) {



        this.platoRepository.save(platoEntity);

    }

    @Override
    public void updatePlato(Plato plato) {

       Optional<PlatoEntity> plato1=  platoRepository.findById(plato.getId());

       if(!plato1.isPresent()){
           throw new PlatoNoExiste(Constants.PLATO_NO_EXITE);

       }

        plato1.get().setPrecio(plato.getPrecio());
        plato1.get().setDescripcion(plato.getDescripcion());


        this.platoRepository.save(plato1.get());
    }

    @Override
    public void deletePlato(Long id) {

        Optional<PlatoEntity>  plato=  platoRepository.findById(id);

        if(!plato.isPresent()){
            throw new PlatoException(Constants.PLATO_NO_EXITE);
        }
        this.platoRepository.delete(plato.get());
    }

    @Override
    public Plato getPlato(Long id) {

        Optional<PlatoEntity> platoEntity = platoRepository.findById(id);
        if(!platoEntity.isPresent()){
            throw new PlatoException(Constants.PLATO_NO_EXITE);

        }
        return platoEntityMapper.platoEntityToPlato(platoEntity.get());

    }

    @Override
    public List<Plato> getAllPlato() {

        List<PlatoEntity>  platoEntityList = platoRepository.findAll();
        if(platoEntityList.size()==0){
            throw new PlatoException(Constants.LISTA_PLATO_NO_VACIA);

        }
        return platoEntityMapper.toPlatoList(platoEntityList);


    }
}

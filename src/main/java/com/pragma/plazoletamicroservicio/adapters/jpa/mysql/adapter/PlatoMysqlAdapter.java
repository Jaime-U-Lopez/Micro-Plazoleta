package com.pragma.plazoletamicroservicio.adapters.jpa.mysql.adapter;
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
    public void savePlato(Plato plato) {

        if(platoRepository.findById(plato.getId()).isPresent()){
            throw new PlatoException(Constants.PLATO_YA_EXITE);
        }
        this.platoRepository.save(platoEntityMapper.platotoPlatoEntity(plato));

    }

    @Override
    public void deletePlato(Plato plato) {

        if(platoRepository.findById(plato.getId()).isPresent()){
            throw new PlatoException(Constants.PLATO_NO_EXITE);
        }
        this.platoRepository.delete(platoEntityMapper.platotoPlatoEntity(plato));
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
package com.pragma.plazoletamicroservicio.domain.usecase;

import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.RestauranteEntity;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.PlatoEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.RestauranteEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IPlatoRepository;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IRestauranteRepository;
import com.pragma.plazoletamicroservicio.domain.api.IPlatoServicePort;
import com.pragma.plazoletamicroservicio.domain.model.Plato;
import com.pragma.plazoletamicroservicio.domain.spi.IPlatoPersistenciaPort;

import java.util.List;
import java.util.Optional;

public class PlatoUseCase implements IPlatoServicePort {



    private final IPlatoPersistenciaPort platoPersistenciaPort;
    private final IPlatoRepository platoRepository;
    private final IRestauranteRepository restauranteRepository;
    private final RestauranteEntityMapper restauranteEntityMapper;
    private final PlatoEntityMapper platoEntityMapper;


    public PlatoUseCase(IPlatoPersistenciaPort platoPersistenciaPort, IPlatoRepository platoRepository, IRestauranteRepository restauranteRepository, RestauranteEntityMapper restauranteEntityMapper, PlatoEntityMapper platoEntityMapper) {
        this.platoPersistenciaPort = platoPersistenciaPort;
        this.platoRepository = platoRepository;
        this.restauranteRepository = restauranteRepository;
        this.restauranteEntityMapper = restauranteEntityMapper;
        this.platoEntityMapper = platoEntityMapper;
    }

    @Override
    public void savePlato(Plato plato) {

//tODO SE DEVE DE ARREGLAR LA VALIDACION DE PROPIETARIO AL MOMENTO DE CREAR

    Optional<RestauranteEntity> restauranteEntityOptional=   restauranteRepository.findById(plato.getRestaurante().getId());


   platoPersistenciaPort.savePlato( platoEntityMapper.platotoPlatoEntity(plato));

    }

    @Override
    public void updatePlato(Plato plato) {

        //TODO ACTUALZIAR EL TEMA DE AUTENTICACION DE PROPIETARIO
        platoPersistenciaPort.updatePlato(plato);

    }

    @Override
    public void deletePlato(Long id) {

        this.platoPersistenciaPort.deletePlato(id);

    }


    @Override
    public Plato getPlato(Long id) {

        return this.platoPersistenciaPort.getPlato(id);
    }

    @Override
    public List<Plato> getAllPlato() {
        return  this.platoPersistenciaPort.getAllPlato();
    }

}

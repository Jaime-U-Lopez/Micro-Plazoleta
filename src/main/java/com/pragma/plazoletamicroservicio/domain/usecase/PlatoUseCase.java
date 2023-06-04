package com.pragma.plazoletamicroservicio.domain.usecase;

import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.PlatoEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IPlatoRepository;
import com.pragma.plazoletamicroservicio.domain.api.IPlatoServicePort;
import com.pragma.plazoletamicroservicio.domain.model.Plato;
import com.pragma.plazoletamicroservicio.domain.spi.IPlatoPersistenciaPort;

import java.util.List;

public class PlatoUseCase implements IPlatoServicePort {



    private final IPlatoPersistenciaPort platoPersistenciaPort;
    private final IPlatoRepository platoRepository;
    private final PlatoEntityMapper platoEntityMapper;

    public PlatoUseCase(IPlatoPersistenciaPort platoPersistenciaPort, IPlatoRepository platoRepository, PlatoEntityMapper platoEntityMapper) {
        this.platoPersistenciaPort = platoPersistenciaPort;
        this.platoRepository = platoRepository;
        this.platoEntityMapper = platoEntityMapper;
    }

    @Override
    public void savePlato(Plato plato) {

//tODO SE DEVE DE ARREGLAR LA VALIDACION DE PROPIETARIO AL MOMENTO DE CREAR
        platoPersistenciaPort.savePlato(plato);


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

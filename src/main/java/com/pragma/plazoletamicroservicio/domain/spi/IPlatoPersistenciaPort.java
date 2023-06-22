package com.pragma.plazoletamicroservicio.domain.spi;

import com.pragma.plazoletamicroservicio.adapters.http.dto.request.PlatoHabilitacionRequestDto;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.PlatoEntity;
import com.pragma.plazoletamicroservicio.domain.model.Plato;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface   IPlatoPersistenciaPort {

    void savePlato(PlatoEntity platoEntity);

    void updatePlato(Plato plato);

    void deletePlato(Long id);

    Plato getPlato(Long id);

    void changeStatePlato(Plato plato);
    List<Plato> getPlatoByRestaurante(String id, String categoria , Pageable pegeable);
    List<Plato> getAllPlato();



}

package com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository;

import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.RestauranteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRestauranteRepository extends JpaRepository<RestauranteEntity,Long> {


    Optional<RestauranteEntity> findRestauranteEntityByIdPropietario(String idPropietario);


    Page<RestauranteEntity> findAllByOrderByNombreAsc(Pageable pageable);

}

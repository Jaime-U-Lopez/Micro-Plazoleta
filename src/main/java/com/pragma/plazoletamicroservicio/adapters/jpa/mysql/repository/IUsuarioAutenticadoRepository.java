package com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository;

import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.RestauranteEntity;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.UsuarioAutenticadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioAutenticadoRepository extends JpaRepository<UsuarioAutenticadoEntity,Long> {

/*
    Optional<RestauranteEntity> findRestauranteEntityByNumeroDocumento(String id);


 */

}

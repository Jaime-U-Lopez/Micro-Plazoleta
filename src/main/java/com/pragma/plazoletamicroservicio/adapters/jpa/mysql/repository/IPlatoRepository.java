package com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository;

import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.PlatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPlatoRepository extends JpaRepository<PlatoEntity ,Long> {




}

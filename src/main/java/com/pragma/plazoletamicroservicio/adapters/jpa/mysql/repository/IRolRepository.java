package com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository;

import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolRepository extends JpaRepository<RolEntity, Long> {
}

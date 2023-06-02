package com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity;

import com.pragma.plazoletamicroservicio.adapters.http.dto.TipoRol;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RolEntity {
    @Id
    private Long id;
    private TipoRol tipoRol;
    private String descripcion;
}

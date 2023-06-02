package com.pragma.plazoletamicroservicio.adapters.http.handlers;


import com.pragma.plazoletamicroservicio.adapters.http.dto.request.RolRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.RolResponseDto;

import java.util.List;

public interface IRoleHandler {
    List<RolResponseDto> getAllRoles();
    void saveRol(RolRequestDto rolRequestDto);
    void deleteRol(RolResponseDto rolResponseDto);

    RolResponseDto getRol(Long id);

}

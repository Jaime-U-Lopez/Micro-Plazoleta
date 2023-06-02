package com.pragma.plazoletamicroservicio.domain.usecase.validaciones;

import com.pragma.plazoletamicroservicio.adapters.http.exceptions.NoEsMayorDeEdadException;
import com.pragma.plazoletamicroservicio.configuration.Constants;

import java.time.LocalDate;
import java.time.Period;

public class ValidacionesUsuario extends ValidacionesGenerales {

    public ValidacionesUsuario() {

    }

    public void validadFechaNacimiento(String fechaNacimiento){
        LocalDate fechaInicio = stringToDate(fechaNacimiento);
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaInicio,fechaActual);
        if(periodo.getYears()<18){
            throw new NoEsMayorDeEdadException(Constants.NO_ES_MAYOR_DE_EDAD);
        }

    }



}

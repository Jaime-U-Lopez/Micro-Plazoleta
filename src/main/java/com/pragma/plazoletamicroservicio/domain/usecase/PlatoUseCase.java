package com.pragma.plazoletamicroservicio.domain.usecase;

import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.PlatoEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IPlatoRepository;
import com.pragma.plazoletamicroservicio.configuration.Constants;
import com.pragma.plazoletamicroservicio.domain.api.IPlatoServicePort;
import com.pragma.plazoletamicroservicio.domain.model.Plato;
import com.pragma.plazoletamicroservicio.domain.spi.IPlatoPersistenciaPort;
import com.pragma.plazoletamicroservicio.domain.usecase.validaciones.ValidacionesUsuario;

import java.util.List;
import java.util.Optional;

public class PlatoUseCase implements IPlatoServicePort {



    private final IPlatoPersistenciaPort platoPersistenciaPort;
    private final IPlatoRepository platoRepository;
    private final PlatoEntityMapper rolEntityMapper;

    public PlatoUseCase(IPlatoPersistenciaPort platoPersistenciaPort, IPlatoRepository platoRepository, PlatoEntityMapper rolEntityMapper) {
        this.platoPersistenciaPort = platoPersistenciaPort;
        this.platoRepository = platoRepository;
        this.rolEntityMapper = rolEntityMapper;
    }

    @Override
    public void savePlato(Plato plato) {


        /*

        ValidacionesUsuario validaciones = new ValidacionesUsuario();
        validaciones.validarFechaNacimientoFormato(usuario.getFechaNacimiento());
        validaciones.validadFechaNacimiento(usuario.getFechaNacimiento());

        Long rolactual= validarRol(rol);
        Optional<RolEntity> rolEntity = rolRepository.findById(rolactual);
        if(rolEntity.isPresent()){
            Rol rols = rolEntityMapper.rolEntityToRol(rolEntity.get());
            usuario.setIdRol(rols);
        }
        this.usuarioPersistencePort.guardarUsuario(usuario);
  */

    }

    @Override
    public void deletePlato(Plato plato) {

        this.platoPersistenciaPort.deletePlato(plato);

    }

    @Override
    public Plato getPlato(Long id) {

        return this.platoPersistenciaPort.getPlato(id);
    }

    @Override
    public List<Plato> getAllPlato() {
        return  this.platoPersistenciaPort.getAllPlato();
    }
/*


    @Override
    public Boolean validarPropietario(Long id) {
        Usuario usuario = this.usuarioPersistencePort.getUsuario(id);
        return usuario.getIdRol().getId().equals(Constants.PROPIETARIO_ROL_ID);
    }
 */

}

package com.pragma.plazoletamicroservicio.domain.usecase;

import com.pragma.plazoletamicroservicio.adapters.http.dto.TipoRol;
import com.pragma.plazoletamicroservicio.adapters.http.exceptions.UsuarioExcepcionRolNoExiste;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.RolEntity;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.RolEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IRolRepository;
import com.pragma.plazoletamicroservicio.configuration.Constants;
import com.pragma.plazoletamicroservicio.domain.api.IUsuarioServicePort;
import com.pragma.plazoletamicroservicio.domain.model.Rol;
import com.pragma.plazoletamicroservicio.domain.model.Usuario;
import com.pragma.plazoletamicroservicio.domain.spi.IUsuarioPersistencePort;
import com.pragma.plazoletamicroservicio.domain.usecase.validaciones.ValidacionesUsuario;

import java.util.Optional;

public class UsuarioUseCase implements IUsuarioServicePort {

    private final IUsuarioPersistencePort usuarioPersistencePort;
    private final IRolRepository rolRepository;
    private final RolEntityMapper rolEntityMapper;

    public UsuarioUseCase(IUsuarioPersistencePort usuarioPersistencePort, IRolRepository rolRepository, RolEntityMapper rolEntityMapper) {
        this.usuarioPersistencePort = usuarioPersistencePort;
        this.rolRepository = rolRepository;
        this.rolEntityMapper = rolEntityMapper;
    }

    @Override
    public void guardarUser(Usuario usuario, TipoRol rol) {
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
    };


    public  Long  validarRol(TipoRol Rol){

            if(Rol.equals(TipoRol.PROPIETARIO) || Rol.equals(TipoRol.CLIENTE)|| Rol.equals(TipoRol.EMPLEADO) ){
                switch(Rol){

                    case PROPIETARIO:
                        return Constants.PROPIETARIO_ROL_ID;
                    case CLIENTE:
                        return Constants.CLIENTE_ROL_ID;
                    case EMPLEADO:
                        return Constants.EMPLEADO_ROL_ID;
                    default:
                        return 0L;
                }
            }else{
                throw new UsuarioExcepcionRolNoExiste("El rol no existe");
            }
    }


    @Override
    public void deleteUsuario(Usuario usuario) {
        this.usuarioPersistencePort.deleteUsuario(usuario);
    }

    @Override
    public Usuario getUsuario(Long id) {
         return this.usuarioPersistencePort.getUsuario(id);
    }

    @Override
    public Boolean validarPropietario(Long id) {
        Usuario usuario = this.usuarioPersistencePort.getUsuario(id);
        return usuario.getIdRol().getId().equals(Constants.PROPIETARIO_ROL_ID);
    }
}

package com.pragma.plazoletamicroservicio.adapters.jpa.mysql.adapter;

import com.pragma.plazoletamicroservicio.adapters.http.exceptions.UsuarioNoSeEncuentraRegistradoException;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.UsuarioEntity;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.exceptions.UsuarioYaExistenteException;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.UsuarioEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IUsuarioRepository;
import com.pragma.plazoletamicroservicio.configuration.Constants;
import com.pragma.plazoletamicroservicio.domain.model.Usuario;
import com.pragma.plazoletamicroservicio.domain.spi.IUsuarioPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UsuarioMysqlAdapter implements IUsuarioPersistencePort {
    private final IUsuarioRepository usuarioRepository;
    private final UsuarioEntityMapper usuarioEntityMapper;
    @Override
    public void guardarUsuario(Usuario usuario) {
        if(usuarioRepository.findUsuarioEntityByCorreo(usuario.getCorreo()).isPresent()){
            throw new UsuarioYaExistenteException(Constants.USUARIO_YA_EXISTE_CORREO);
        }
        if(usuarioRepository.findUsuarioEntityByNumeroDocumento(usuario.getNumeroDocumento()).isPresent()){
            throw new UsuarioYaExistenteException(Constants.USUARIO_YA_EXISTE_DOCUMENTO);
        }
        this.usuarioRepository.save(usuarioEntityMapper.toEntity(usuario));
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        this.usuarioRepository.delete(this.usuarioEntityMapper.toEntity(usuario));
    }

    @Override
    public Usuario getUsuario(Long id) {
        Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findById(id);
        if(!usuarioEntity.isPresent()){
            throw new UsuarioNoSeEncuentraRegistradoException(Constants.USUARIO_NO_REGISTRADO);

        }
        return usuarioEntityMapper.toUsuario(usuarioEntity.get());
    }
}

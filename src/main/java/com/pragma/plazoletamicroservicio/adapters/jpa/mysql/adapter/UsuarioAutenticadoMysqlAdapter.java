package com.pragma.plazoletamicroservicio.adapters.jpa.mysql.adapter;

import com.pragma.plazoletamicroservicio.adapters.http.exceptions.RestauranteNoExiste;
import com.pragma.plazoletamicroservicio.adapters.http.exceptions.UsuarioNoSeEncuentraRegistradoException;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.RestauranteEntity;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.UsuarioAutenticadoEntity;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.RestauranteEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.UsuarioAutenticadoEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IRestauranteRepository;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IUsuarioAutenticadoRepository;
import com.pragma.plazoletamicroservicio.configuration.Constants;
import com.pragma.plazoletamicroservicio.domain.model.Restaurante;
import com.pragma.plazoletamicroservicio.domain.model.UsuarioAutenticado;
import com.pragma.plazoletamicroservicio.domain.spi.IRestaurantePersistenciaPort;
import com.pragma.plazoletamicroservicio.domain.spi.IUsuarioAutenticadoPersistenciaPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class UsuarioAutenticadoMysqlAdapter implements IUsuarioAutenticadoPersistenciaPort {


    private IUsuarioAutenticadoRepository usuarioAutenticadoRepository;
    private UsuarioAutenticadoEntityMapper usuarioAutenticadoEntityMapper ;


    public UsuarioAutenticadoMysqlAdapter(IUsuarioAutenticadoRepository usuarioAutenticadoRepository, UsuarioAutenticadoEntityMapper usuarioAutenticadoEntityMapper) {
        this.usuarioAutenticadoRepository = usuarioAutenticadoRepository;
        this.usuarioAutenticadoEntityMapper = usuarioAutenticadoEntityMapper;
    }

    @Override
    public void saveUser(UsuarioAutenticado usuarioAutenticado) {

        usuarioAutenticadoRepository.save(usuarioAutenticadoEntityMapper.UsuarioAutenticaotoUsuarioEntity(usuarioAutenticado));
    }

    @Override
    public void deleteUser(Long id) {

        usuarioAutenticadoRepository.deleteById(id);

    }

    @Override
    public UsuarioAutenticado getUser(Long id) {

        Optional<UsuarioAutenticadoEntity>  usuarioAutenticadoEntity  = usuarioAutenticadoRepository.findById(id);

        if(!usuarioAutenticadoEntity.isPresent()){
            throw  new UsuarioNoSeEncuentraRegistradoException("El usuario no esta registrado en la base de datos");
        }

        return usuarioAutenticadoEntityMapper.usuarioAutenticadoEntityToUsuario(usuarioAutenticadoEntity.get());

    }
}

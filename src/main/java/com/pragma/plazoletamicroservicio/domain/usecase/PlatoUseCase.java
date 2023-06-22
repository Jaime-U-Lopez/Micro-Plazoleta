package com.pragma.plazoletamicroservicio.domain.usecase;

import com.pragma.plazoletamicroservicio.adapters.http.dto.response.UsuarioResponseDto;
import com.pragma.plazoletamicroservicio.adapters.http.exceptions.UsuarioNoSeEncuentraRegistradoException;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.RestauranteEntity;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.UsuarioAutenticadoEntity;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.PlatoEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.RestauranteEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IPlatoRepository;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IRestauranteRepository;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IUsuarioAutenticadoRepository;
import com.pragma.plazoletamicroservicio.configuration.FeignClient.UserHandlerFeing;
import com.pragma.plazoletamicroservicio.domain.api.IPlatoServicePort;
import com.pragma.plazoletamicroservicio.domain.model.Plato;
import com.pragma.plazoletamicroservicio.domain.spi.IPlatoPersistenciaPort;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class PlatoUseCase implements IPlatoServicePort {



    private final IPlatoPersistenciaPort platoPersistenciaPort;
    private final IPlatoRepository platoRepository;
    private final IRestauranteRepository restauranteRepository;
    private final RestauranteEntityMapper restauranteEntityMapper;
    private final PlatoEntityMapper platoEntityMapper;

    private final IUsuarioAutenticadoRepository usuarioAutenticadoRepository;

    private UserHandlerFeing userHandlerFeing;

    public PlatoUseCase(IPlatoPersistenciaPort platoPersistenciaPort, IPlatoRepository platoRepository, IRestauranteRepository restauranteRepository, RestauranteEntityMapper restauranteEntityMapper, PlatoEntityMapper platoEntityMapper, IUsuarioAutenticadoRepository usuarioAutenticadoRepository, UserHandlerFeing userHandlerFeing) {
        this.platoPersistenciaPort = platoPersistenciaPort;
        this.platoRepository = platoRepository;
        this.restauranteRepository = restauranteRepository;
        this.restauranteEntityMapper = restauranteEntityMapper;
        this.platoEntityMapper = platoEntityMapper;
        this.usuarioAutenticadoRepository = usuarioAutenticadoRepository;
        this.userHandlerFeing = userHandlerFeing;
    }

    @Override
    public void savePlato(Plato plato) {

   Optional <UsuarioAutenticadoEntity> usuarioRepositorio= usuarioAutenticadoRepository.findById(1L);

   if(!usuarioRepositorio.isPresent()){
            throw new UsuarioNoSeEncuentraRegistradoException("No hay usuario autenticado de Propietario");
   }

    Optional<UsuarioResponseDto> usuarioLogueado = userHandlerFeing.getOwner(usuarioRepositorio.get().getNombreUsuario());

    Optional<RestauranteEntity> restauranteEntityOptional=   restauranteRepository.findRestauranteEntityByIdPropietario(usuarioLogueado.get().getId());

   plato.setRestaurante( restauranteEntityMapper.restauranteEntityToRestaurante(restauranteEntityOptional.get()));

   platoPersistenciaPort.savePlato( platoEntityMapper.platotoPlatoEntity(plato));

    }

    @Override
    public void updatePlato(Plato plato) {


        Optional <UsuarioAutenticadoEntity> usuarioRepositorio= usuarioAutenticadoRepository.findById(1L);

        if(!usuarioRepositorio.isPresent()){
            throw new UsuarioNoSeEncuentraRegistradoException("No hay usuario autenticado de Propietario");
        }

        Optional<UsuarioResponseDto> usuarioLogueado = userHandlerFeing.getOwner(usuarioRepositorio.get().getNombreUsuario());




        platoPersistenciaPort.updatePlato(plato);

    }

    @Override
    public void deletePlato(Long id) {

        this.platoPersistenciaPort.deletePlato(id);

    }


    @Override
    public Plato getPlato(Long id) {

        return this.platoPersistenciaPort.getPlato(id);
    }

    @Override
    public List<Plato> getPlatoByRestaurante(String id, String categoria , Pageable pegeable) {
        return this.platoPersistenciaPort.getPlatoByRestaurante( id,  categoria , pegeable);
    }

    @Override
    public List<Plato> getAllPlato() {
        return  this.platoPersistenciaPort.getAllPlato();
    }

}

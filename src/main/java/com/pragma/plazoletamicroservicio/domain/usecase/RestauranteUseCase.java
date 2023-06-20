package com.pragma.plazoletamicroservicio.domain.usecase;

import com.pragma.plazoletamicroservicio.adapters.http.dto.response.UsuarioResponseDto;
import com.pragma.plazoletamicroservicio.adapters.http.exceptions.UsuarioNoSeEncuentraRegistradoException;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.UsuarioAutenticadoEntity;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.RestauranteEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IRestauranteRepository;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IUsuarioAutenticadoRepository;
import com.pragma.plazoletamicroservicio.configuration.FeignClient.UserHandlerFeing;
import com.pragma.plazoletamicroservicio.domain.api.IRestauranteServicePort;
import com.pragma.plazoletamicroservicio.domain.model.Restaurante;
import com.pragma.plazoletamicroservicio.domain.spi.IRestaurantePersistenciaPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RestauranteUseCase implements IRestauranteServicePort {

    private final IRestauranteRepository restauranteRepository;
    private final RestauranteEntityMapper restauranteEntityMapper;
    private final IRestaurantePersistenciaPort restaurantePersistenciaPort;

    private final IUsuarioAutenticadoRepository usuarioAutenticadoRepository;

    @Autowired
    private UserHandlerFeing userHandlerFeing;

    public RestauranteUseCase(IRestauranteRepository restauranteRepository, RestauranteEntityMapper restauranteEntityMapper, IRestaurantePersistenciaPort restaurantePersistenciaPort, IUsuarioAutenticadoRepository usuarioAutenticadoRepository, UserHandlerFeing userHandlerFeing) {
        this.restauranteRepository = restauranteRepository;
        this.restauranteEntityMapper = restauranteEntityMapper;
        this.restaurantePersistenciaPort = restaurantePersistenciaPort;
        this.usuarioAutenticadoRepository = usuarioAutenticadoRepository;
        this.userHandlerFeing = userHandlerFeing;
    }

    @Override
    public void saveRestaurante(Restaurante restaurante) {


        Optional <UsuarioAutenticadoEntity> usuario= usuarioAutenticadoRepository.findById(1L);
        if(!usuario.isPresent()){

            throw new UsuarioNoSeEncuentraRegistradoException("El id ingresado esta autenticado");
        }

        Optional<UsuarioResponseDto> response = userHandlerFeing.getOwner( usuario.get().getNombreUsuario());

        restaurantePersistenciaPort.saveRestaurante(restaurante);

    }

    @Override
    public void deleteRestaurante(Long id ) {


        restaurantePersistenciaPort.deleteRestaurante(id);

    }

    @Override
    public Restaurante getRestaurante(Long id) {
        return restaurantePersistenciaPort.getRestaurante(id);
    }

    @Override
    public List<Restaurante> getAllRestaurante() {
        return restaurantePersistenciaPort.getAllRestaurante();
    }
}

package com.pragma.plazoletamicroservicio.domain.usecase;

import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.RestauranteEntity;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.RestauranteEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IRestauranteRepository;
import com.pragma.plazoletamicroservicio.domain.api.IRestauranteServicePort;
import com.pragma.plazoletamicroservicio.domain.model.Restaurante;
import com.pragma.plazoletamicroservicio.domain.spi.IRestaurantePersistenciaPort;

import java.util.List;
import java.util.Optional;

public class RestauranteUseCase implements IRestauranteServicePort {

    private final IRestauranteRepository restauranteRepository;
    private final RestauranteEntityMapper restauranteEntityMapper;
    private final IRestaurantePersistenciaPort restaurantePersistenciaPort;

    public RestauranteUseCase(IRestauranteRepository restauranteRepository, RestauranteEntityMapper restauranteEntityMapper, IRestaurantePersistenciaPort restaurantePersistenciaPort) {
        this.restauranteRepository = restauranteRepository;
        this.restauranteEntityMapper = restauranteEntityMapper;
        this.restaurantePersistenciaPort = restaurantePersistenciaPort;
    }

    @Override
    public void saveRestaurante(Restaurante restaurante) {
// TODO SE DEBE DE ARREGLAR LA VALICACION DE PRIIETARIO EN RESTAURANTE
        Long idPropietario= restaurante.getIdPropietario();

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

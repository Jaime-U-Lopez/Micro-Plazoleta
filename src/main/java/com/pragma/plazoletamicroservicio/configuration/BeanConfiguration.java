package com.pragma.plazoletamicroservicio.configuration;

import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.adapter.PlatoMysqlAdapter;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.adapter.RestauranteMysqlAdapter;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.PlatoEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.RestauranteEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IPlatoRepository;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IRestauranteRepository;
import com.pragma.plazoletamicroservicio.domain.api.IPlatoServicePort;
import com.pragma.plazoletamicroservicio.domain.api.IRestauranteServicePort;
import com.pragma.plazoletamicroservicio.domain.spi.IPlatoPersistenciaPort;
import com.pragma.plazoletamicroservicio.domain.spi.IRestaurantePersistenciaPort;
import com.pragma.plazoletamicroservicio.domain.usecase.PlatoUseCase;
import com.pragma.plazoletamicroservicio.domain.usecase.RestauranteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IPlatoRepository platoRepository;
    private final RestauranteEntityMapper restauranteEntityMapper;

    private final IRestauranteRepository restauranteRepository;
    private final PlatoEntityMapper platoEntityMapper;

    @Bean
    public IRestauranteServicePort restauranteServicePort(){
        return new RestauranteUseCase(restauranteRepository, restauranteEntityMapper, restaurantePersistencePort());
    }

    @Bean
    public IPlatoServicePort platoServicePort(){
        return new PlatoUseCase(platoPersistencePort(),platoRepository,platoEntityMapper);
    }


    @Bean
    public IRestaurantePersistenciaPort restaurantePersistencePort() {
        return new RestauranteMysqlAdapter(restauranteRepository, restauranteEntityMapper );
    }

    @Bean
    public IPlatoPersistenciaPort platoPersistencePort() {
        return new PlatoMysqlAdapter(platoRepository,platoEntityMapper);
    }

}

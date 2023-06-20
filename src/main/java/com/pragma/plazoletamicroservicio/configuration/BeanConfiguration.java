package com.pragma.plazoletamicroservicio.configuration;

import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.adapter.PedidoMysqlAdapter;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.adapter.PlatoMysqlAdapter;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.adapter.RestauranteMysqlAdapter;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.adapter.UsuarioAutenticadoMysqlAdapter;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.PedidoEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.PlatoEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.RestauranteEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.UsuarioAutenticadoEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IPedidoRepository;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IPlatoRepository;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IRestauranteRepository;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IUsuarioAutenticadoRepository;
import com.pragma.plazoletamicroservicio.configuration.FeignClient.UserHandlerFeing;
import com.pragma.plazoletamicroservicio.domain.api.IPedidoServicePort;
import com.pragma.plazoletamicroservicio.domain.api.IPlatoServicePort;
import com.pragma.plazoletamicroservicio.domain.api.IRestauranteServicePort;
import com.pragma.plazoletamicroservicio.domain.api.IUsuarioAutenticadoServicePort;
import com.pragma.plazoletamicroservicio.domain.spi.IPedidoPersistenciaPort;
import com.pragma.plazoletamicroservicio.domain.spi.IPlatoPersistenciaPort;
import com.pragma.plazoletamicroservicio.domain.spi.IRestaurantePersistenciaPort;
import com.pragma.plazoletamicroservicio.domain.spi.IUsuarioAutenticadoPersistenciaPort;
import com.pragma.plazoletamicroservicio.domain.usecase.PedidoUseCase;
import com.pragma.plazoletamicroservicio.domain.usecase.PlatoUseCase;
import com.pragma.plazoletamicroservicio.domain.usecase.RestauranteUseCase;
import com.pragma.plazoletamicroservicio.domain.usecase.UsuarioAutenticadoUseCase;
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

    private final IPedidoRepository pedidoRepository;
    private final PedidoEntityMapper pedidoEntityMapper;

    private final IUsuarioAutenticadoRepository usuarioAutenticadoRepository;
    private final UsuarioAutenticadoEntityMapper usuarioAutenticadoEntityMapper;
    private  final UserHandlerFeing userHandlerFeing;

    @Bean
    public IRestauranteServicePort restauranteServicePort(){
        return new RestauranteUseCase(restauranteRepository, restauranteEntityMapper, restaurantePersistencePort(), usuarioAutenticadoRepository,userHandlerFeing);
    }

    @Bean
    public IPlatoServicePort platoServicePort(){
        return new PlatoUseCase(platoPersistencePort(),platoRepository, restauranteRepository , restauranteEntityMapper, platoEntityMapper, usuarioAutenticadoRepository, userHandlerFeing);
    }


    @Bean
    public IPedidoServicePort pedidoServicePort(){
        return new PedidoUseCase(pedidoPersistenciaPort(),pedidoRepository,pedidoEntityMapper);
    }

    @Bean
    public IUsuarioAutenticadoServicePort usuarioAutenticadoServicePort(){
        return new UsuarioAutenticadoUseCase(usuarioAutenticadoRepository,usuarioAutenticadoEntityMapper, usuarioAutenticadoPersistenciaPort());
    }


    @Bean
    public IRestaurantePersistenciaPort restaurantePersistencePort() {
        return new RestauranteMysqlAdapter(restauranteRepository, restauranteEntityMapper );
    }



    @Bean
    public IPlatoPersistenciaPort platoPersistencePort() {
        return new PlatoMysqlAdapter(platoRepository,platoEntityMapper);
    }


    @Bean
    public IPedidoPersistenciaPort pedidoPersistenciaPort() {
        return new PedidoMysqlAdapter(pedidoRepository,pedidoEntityMapper);
    }

    @Bean
    public IUsuarioAutenticadoPersistenciaPort  usuarioAutenticadoPersistenciaPort() {
        return new UsuarioAutenticadoMysqlAdapter(usuarioAutenticadoRepository, usuarioAutenticadoEntityMapper);
    }

}

package com.pragma.plazoletamicroservicio.adapters.jpa.mysql.adapter;

import com.pragma.plazoletamicroservicio.adapters.http.exceptions.RestauranteNoExiste;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.RestauranteEntity;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.RestauranteEntityMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.repository.IRestauranteRepository;
import com.pragma.plazoletamicroservicio.configuration.Constants;
import com.pragma.plazoletamicroservicio.domain.model.Plato;
import com.pragma.plazoletamicroservicio.domain.model.Restaurante;
import com.pragma.plazoletamicroservicio.domain.spi.IRestaurantePersistenciaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.awt.*;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class RestauranteMysqlAdapter  implements IRestaurantePersistenciaPort {


    private IRestauranteRepository restauranteRepository;
    private  RestauranteEntityMapper restauranteEntityMapper;

    public RestauranteMysqlAdapter(IRestauranteRepository restauranteRepository, RestauranteEntityMapper restauranteEntityMapper) {
        this.restauranteRepository = restauranteRepository;
        this.restauranteEntityMapper = restauranteEntityMapper;
    }

    @Override
    public void saveRestaurante(Restaurante restaurante) {

        RestauranteEntity  restauranteEntity=  restauranteEntityMapper.restaurantetoRestauranteEntity(restaurante);
        restauranteRepository.save(restauranteEntity);

    }

    @Override
    public void deleteRestaurante(Long id ) {


        Optional<RestauranteEntity> restauranteOptional= restauranteRepository.findById(id);

        if (!restauranteOptional.isPresent()){
            throw new RestauranteNoExiste(Constants.RESTAURANTE_NO_EXISTE);
        }

         restauranteRepository.delete(restauranteOptional.get());

    }

    @Override
    public Restaurante getRestaurante(Long id) {

        Optional<RestauranteEntity> restauranteOptional=  restauranteRepository.findById(id);
        if (!restauranteOptional.isPresent()){
            throw new RestauranteNoExiste(Constants.RESTAURANTE_NO_EXISTE);
        }


        return    restauranteEntityMapper.restauranteEntityToRestaurante(restauranteOptional.get());
    }


    @Override
    public List<Restaurante> getAllRestaurante(Pageable pageable) {




        return  restauranteEntityMapper.toRestauranteList(restauranteRepository.findAllByOrderByNombreAsc(pageable));
    }
}

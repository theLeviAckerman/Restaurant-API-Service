package com.cherry.restaurant.service;


import com.cherry.restaurant.dto.RestaurantDto;
import com.cherry.restaurant.entity.Restaurant;
import com.cherry.restaurant.mapper.RestaurantMapper;
import com.cherry.restaurant.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {


    @Autowired
    RestaurantRepo restaurantRepo;


    public List<RestaurantDto> findAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepo.findAll();
        List<RestaurantDto> restaurantsDto = restaurants.stream().map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant)).collect(Collectors.toList());
        return restaurantsDto;

    }

    public RestaurantDto addRestaurantInDb(RestaurantDto restaurantDto) {
         Restaurant restaurant= restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDtoToRestaurant(restaurantDto));

         return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant);

    }


    public ResponseEntity<RestaurantDto> findRestaurantsById(Integer id) {

        Optional<Restaurant> restaurant = restaurantRepo.findById(id);

        if(restaurant.isPresent()){
            return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant.get()), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}

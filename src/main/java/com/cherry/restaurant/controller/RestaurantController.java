package com.cherry.restaurant.controller;

import com.cherry.restaurant.dto.RestaurantDto;
import com.cherry.restaurant.service.RestaurantService;
import com.netflix.discovery.converters.Auto;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/getAllRestaurants")
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
        List<RestaurantDto> allRestaurants = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
    }

    @GetMapping("/getRestaurantById/{id}")
    public ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable Integer id) {
        return restaurantService.findRestaurantsById(id);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDto> addRestaurant(@RequestBody RestaurantDto restaurantDto) {

        RestaurantDto restaurantAdded = restaurantService.addRestaurantInDb(restaurantDto);
        return new ResponseEntity<>(restaurantAdded, HttpStatus.OK);
    }


}

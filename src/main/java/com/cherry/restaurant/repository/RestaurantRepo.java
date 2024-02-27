package com.cherry.restaurant.repository;

import com.cherry.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {
}

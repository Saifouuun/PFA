package com.fsb.gestion_restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsb.gestion_restaurant.models.Restaurant;

@Repository
public interface RestaurantRepository  extends JpaRepository<Restaurant,Long>{
    List<Restaurant> findByNomRestaurant(String nomRestaurant);
    List<Restaurant> findByNomRestaurantStartingWithIgnoreCase(String prefix);
    List<Restaurant> findByNomRestaurantStartingWith(String prefix);

}

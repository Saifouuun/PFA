package com.fsb.gestion_restaurant.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsb.gestion_restaurant.dao.models.Restaurant;

@Repository
public interface RestaurantRepository  extends JpaRepository<Restaurant,Long>{
    List<Restaurant> findByNomRestaurant(String nomRestaurant);
    List<Restaurant> findByLocationStartingWithIgnoreCase(String prefix);
    List<Restaurant> findByLocationStartingWith(String prefix);

}

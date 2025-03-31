package com.fsb.gestion_restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsb.gestion_restaurant.models.Menu;

public interface MenuRepository extends JpaRepository<Menu,Long> {

}

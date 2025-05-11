package com.fsb.gestion_restaurant.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsb.gestion_restaurant.dao.models.Menu;

public interface MenuRepository extends JpaRepository<Menu,Long> {

}

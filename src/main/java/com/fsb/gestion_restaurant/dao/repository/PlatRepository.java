package com.fsb.gestion_restaurant.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsb.gestion_restaurant.dao.models.Plat;

@Repository
public interface PlatRepository extends JpaRepository<Plat,Long> {

}

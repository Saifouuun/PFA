package com.fsb.gestion_restaurant.dao.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.fsb.gestion_restaurant.dao.models.ResTable;


public interface TableRepository extends JpaRepository<ResTable, Long> {
    
}


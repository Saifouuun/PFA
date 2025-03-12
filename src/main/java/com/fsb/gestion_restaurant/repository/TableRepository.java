package com.fsb.gestion_restaurant.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.fsb.gestion_restaurant.models.ResTable;


public interface TableRepository extends JpaRepository<ResTable, Long> {
    
}


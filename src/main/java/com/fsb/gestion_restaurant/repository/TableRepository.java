package com.fsb.gestion_restaurant.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.fsb.gestion_restaurant.models.Table;


public interface TableRepository extends JpaRepository<Table, Long> {
    
}

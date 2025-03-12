package com.fsb.gestion_restaurant.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.fsb.gestion_restaurant.models.Commande;

public interface CommandeRepository extends JpaRepository<Commande,Long> {


}

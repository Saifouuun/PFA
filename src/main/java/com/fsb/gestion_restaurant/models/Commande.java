package com.fsb.gestion_restaurant.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;

    @Column(name = "commandeDetails")
    private String comDetails;

    public Commande(Long idCommande, String comDetails) {
        this.idCommande = idCommande;
        this.comDetails = comDetails;
    }
    


}

package com.fsb.gestion_restaurant.dao.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "commandes")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;

    @Column(name = "commandeDetails")
    private String comDetails;

    @ManyToOne
    @JoinColumn(name = "restaurant_id" , nullable = false)
    private Restaurant restaurant;

    public Commande(Long idCommande, String comDetails,Restaurant restaurant) {
        this.idCommande = idCommande;
        this.comDetails = comDetails;
        this.restaurant=restaurant;
    }
    


}

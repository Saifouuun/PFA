package com.fsb.gestion_restaurant.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "plats")
public class Plat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomPlat;

    private String descriiption;

    private double prix;

    private String image;

    @ManyToOne
    private Menu menu;

    public Plat(String nomPlat, String descriiption, double prix, String image,Menu menu) {
        this.nomPlat = nomPlat;
        this.descriiption = descriiption;
        this.prix = prix;
        this.image = image;
        this.menu=menu;
    }


}

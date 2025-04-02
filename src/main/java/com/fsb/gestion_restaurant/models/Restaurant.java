package com.fsb.gestion_restaurant.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomRestaurant;

    private String location;

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Menu> menus;

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Commande> commandes;

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ResTable> tables;

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Reservation> reservations;

    @ManyToOne
    @JoinColumn(name = "owner" , nullable = false)
    private User owner;

    public Restaurant(String nomRestaurant, String location, List<Menu> menus, List<Commande> commandes,
        List<ResTable> tables, List<Reservation> reservations, User owner) {
        this.nomRestaurant = nomRestaurant;
        this.location = location;
        this.menus = menus;
        this.commandes = commandes;
        this.tables = tables;
        this.reservations = reservations;
        if (owner.getRole().equals("OWNER")) {
            this.owner= owner;
        }
    }
    public Restaurant(){}



}

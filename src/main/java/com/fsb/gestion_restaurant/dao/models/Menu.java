package com.fsb.gestion_restaurant.dao.models;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "menus")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomMenu;


    @OneToMany(mappedBy = "menu",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Plat> plats;

    @ManyToOne
    @JoinColumn(name = "restaurant_id" , nullable = false)
    private Restaurant restaurant;

    public Menu() {}

    public Menu(String nomMenu,List<Plat> plats,Restaurant restaurant){
        this.nomMenu = nomMenu;
        this.plats=plats;
        this.restaurant=restaurant;
    }
}

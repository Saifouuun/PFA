package com.fsb.gestion_restaurant.dao.models;

import java.sql.Date;

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
@Table(name="reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    

    private Date dateReservation;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id" , nullable = false)
    private Restaurant restaurant;

    public Reservation(User user, Date dateReservation,Restaurant restaurant) {
        this.user = user;
        this.dateReservation = dateReservation;
        this.restaurant=restaurant;
    }
    public Reservation(){}


    

}

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
@Table(name = "tables")
public class ResTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numTable")
    private int numTable;
    @Column(name = "capacity")
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "restaurant_id" , nullable = false)
    private Restaurant restaurant;

    public ResTable(Long id, int capacity,int numTable,Restaurant restaurant) {
        this.id = id;
        this.capacity = capacity;
        this.numTable=numTable;
        this.restaurant=restaurant;
    }
    public ResTable() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
;

}

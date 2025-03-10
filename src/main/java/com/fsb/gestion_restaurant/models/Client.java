package com.fsb.gestion_restaurant.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="client")
public class Client  {
  
    @Id
    @Column(name = "key")
    private String key;
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }

    


}

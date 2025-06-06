package com.fsb.gestion_restaurant.web.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.fsb.gestion_restaurant.business.service.CommandeService;
import com.fsb.gestion_restaurant.dao.models.Commande;

@RestController
@RequestMapping("/commande")
public class CommandeController {
    @Autowired
    CommandeService commandeService;

    @PostMapping
    public Commande createCommande(@RequestBody Commande commande){
        return commandeService.createCommande(commande);
    }
    @GetMapping("/get/{id}")
    public Commande getCommandeByid(@PathVariable Long id){
        return commandeService.getCommandeById(id).get();
    }
    @PutMapping
    public Commande updateUser(@RequestBody Commande commande) {
        return commandeService.updateCommande(commande);
    }


    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable Long id) {
        commandeService.deleteCommande(id);
    }

}

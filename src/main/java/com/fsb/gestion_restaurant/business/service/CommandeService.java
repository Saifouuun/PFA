package com.fsb.gestion_restaurant.business.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsb.gestion_restaurant.dao.models.Commande;
import com.fsb.gestion_restaurant.dao.repository.CommandeRepository;

@Service
public class CommandeService {

    @Autowired
    CommandeRepository commandeRepository;

    public Commande createCommande(Commande commande){
        return commandeRepository.save(commande);
    }
    public Commande updateCommande(Commande commande){
        return commandeRepository.save(commande);
    }
    public Optional<Commande> getCommandeById(Long id){
        return commandeRepository.findById(id);
    }
    public void deleteCommande(Long id){
        commandeRepository.deleteById(id);
    }


}

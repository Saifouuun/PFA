package com.fsb.gestion_restaurant.business.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsb.gestion_restaurant.dao.models.ResTable;
import com.fsb.gestion_restaurant.dao.repository.TableRepository;

@Service
public class TableService {
    @Autowired
    TableRepository tableRepo;

    public ResTable createTable(ResTable table){
        return tableRepo.save(table);
    }
    public ResTable updateTable(ResTable table){
        return tableRepo.save(table);
    }
    public Optional<ResTable> getTableById(Long id) {
        return tableRepo.findById(id); 
    }
    public void deleteTable(Long id) {
        tableRepo.deleteById(id);  
    }

}

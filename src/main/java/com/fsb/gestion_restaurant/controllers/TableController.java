package com.fsb.gestion_restaurant.controllers;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsb.gestion_restaurant.models.ResTable;
import com.fsb.gestion_restaurant.service.TableService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/table")
public class TableController {

    @Autowired
    TableService tableService;

    @PostMapping
    public ResTable createTable(@RequestBody ResTable table) {
        return tableService.createTable(table);
    }
    @GetMapping("/{id}")
    public ResTable getTableById(@PathVariable("id") Long id) {
        return tableService.getTableById(id).get();
        
    }

    @PutMapping
    public ResTable updateUser(@RequestBody ResTable table) {
        return tableService.updateTable(table);
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        tableService.deleteTable(id);
    }

 
    
    

}

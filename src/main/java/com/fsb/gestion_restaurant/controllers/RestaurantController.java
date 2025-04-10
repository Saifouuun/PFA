package com.fsb.gestion_restaurant.controllers;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.fsb.gestion_restaurant.models.Restaurant;
import com.fsb.gestion_restaurant.models.User;
import com.fsb.gestion_restaurant.repository.RestaurantRepository;
import com.fsb.gestion_restaurant.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;




@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private  RestaurantRepository restaurantRepository;

    @Autowired
    private  UserService userService;

    @PostMapping("/create")
    @ResponseBody
    public String createRestaurant(@RequestParam String location,@RequestParam String nomResto,@RequestParam Long id) {
        User user = userService.getUserById(id).get();
        if (user==null) {
            return "user not found";
        }
        if (user.isOwner(user) == false) {
            return "only owner can create a restauarant";
        }
        
        Restaurant restaurant = new Restaurant();
        restaurant.setLocation(location);
        restaurant.setNomRestaurant(nomResto);
        restaurant.setOwner(userService.getUserById(id).get());
        restaurantRepository.save(restaurant);
        return "Restaurant created successfully";
   
    
    }
    @GetMapping("/getAll")
    public String getresto(Model model) {
        model.addAttribute("restaurants", restaurantRepository.findAll());
        return "home";
    }
    @GetMapping("/getall")
    @ResponseBody
    public List<Restaurant> getAllResto() {
        return restaurantRepository.findAll();
    }

    @PostMapping("/update/{id}")
    public String putResto(@RequestParam String nomR,@PathVariable Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).get();
        restaurant.setNomRestaurant(nomR);
        restaurantRepository.save(restaurant);
        return "restaurant updated successfully";
    }
    @GetMapping("/search")
    @ResponseBody
    public List<Restaurant> searchItems(@RequestParam("keyword") String query) {
        return restaurantRepository.findByNomRestaurantStartingWith(query); 
    }
    @GetMapping("/searchPage")
    public String search() {
        return "search"; 
    }
    




}

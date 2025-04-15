package com.fsb.gestion_restaurant.controllers;

import java.sql.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fsb.gestion_restaurant.models.Reservation;
import com.fsb.gestion_restaurant.models.User;
import com.fsb.gestion_restaurant.repository.ReservationRepository;
import com.fsb.gestion_restaurant.repository.UserRepository;


@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping
    @ResponseBody
    public String createReservation(@RequestParam Date date,@RequestParam Long userId) {
        User user = userRepository.findById(userId).get();
        Reservation res = new Reservation();
        res.setDateReservation(date);
        res.setUser(user);
        reservationRepository.save(res);
        return "reservation saved";
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @GetMapping("/findByEmail")
    @ResponseBody
    public String getReservationByUserId(@RequestParam String email) {

        try{
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        


        List<Reservation> reservations = reservationRepository.findByUserId(user.getId());
        if (reservations.isEmpty()) {
            return "No reservations found";
            
        }
        return reservations.get(0).getUser().getUsername()+" have a reservation";
    }catch(Exception e){
        return e.getMessage();
    }

}
}

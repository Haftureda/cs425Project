package edu.mum.cs5.airTicketbooking.service;

import edu.mum.cs5.airTicketbooking.model.Reservation;
import edu.mum.cs5.airTicketbooking.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    public String  saveReservation(Reservation reservation){
         reservationRepository.save(reservation);
      return "booking reservation done>>>";
    }
//
//    public String  cancelReservation(Reservation reservation){
//        reservationRepository.save(reservation);
//        return "booking reservation done>>>";
//    }
}

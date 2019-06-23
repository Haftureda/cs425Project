package edu.mum.cs5.airTicketbooking.repository;

import edu.mum.cs5.airTicketbooking.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}

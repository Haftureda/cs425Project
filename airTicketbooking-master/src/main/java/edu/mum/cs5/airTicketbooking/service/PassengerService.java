package edu.mum.cs5.airTicketbooking.service;

import edu.mum.cs5.airTicketbooking.model.Passenger;
import edu.mum.cs5.airTicketbooking.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PassengerService {
	
	@Autowired
	private PassengerRepository passengerRepository;

	public List<Passenger> getPassenger() {
		
		
		return passengerRepository.findAll();
	}

	public Passenger addNewPassenger(Passenger passenger) {
		
		
		return passengerRepository.save(passenger);
	}

	public Passenger updatePassenger(int id) {
		
		return passengerRepository.getOne(id);
		//passengerRepository.existsById(id)or.Else(null);
	}

	public Passenger getPassengerById(int id) {
		
		return passengerRepository.findById(id).orElse(null);
	}

	public void delete(int id) {
		
		passengerRepository.deleteById(id);
		
	}

}

//package edu.mum.cs5.airTicketbooking.serviceImpl;
//
//import edu.mum.se425.flightBooking.model.Passenger;
//import edu.mum.se425.flightBooking.repository.PassengerRepository;
//import edu.mum.se425.flightBooking.service.PassengerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//
//@Service
//public class PassengerServiceImpl implements PassengerService{
//
//	@Autowired
//	private PassengerRepository passengerRepository;
//
//	@Override
//	public List<Passenger> getPassenger() {
//
//
//		return passengerRepository.findAll();
//	}
//
//	@Override
//	public Passenger addNewPassenger(Passenger passenger) {
//
//
//		return passengerRepository.save(passenger);
//	}
//
//	@Override
//	public Passenger updatePassenger(int id) {
//
//		return passengerRepository.getOne(id);
//		//passengerRepository.existsById(id)or.Else(null);
//	}
//
//	@Override
//	public Passenger getPassengerById(int id) {
//
//		return passengerRepository.findById(id).orElse(null);
//	}
//
//	@Override
//	public void delete(int id) {
//
//		passengerRepository.deleteById(id);
//
//	}
//
//}

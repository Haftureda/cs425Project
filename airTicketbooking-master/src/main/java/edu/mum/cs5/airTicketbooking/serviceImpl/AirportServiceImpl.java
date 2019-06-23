package edu.mum.cs5.airTicketbooking.serviceImpl;//package edu.mum.se425.flightBooking.serviceImpl;
//
//import java.util.List;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.stereotype.Service;
//
//import edu.mum.se425.flightBooking.model.Airport;
//import edu.mum.se425.flightBooking.repository.AirportRepository;
//import edu.mum.se425.flightBooking.service.AirportService;
//
//
//@Service
//public class AirportServiceImpl implements AirportService{
//
//	@Autowired
//	private AirportRepository airportRepository;
//
//
//	@Override
//	public Airport save(Airport airport) {
//
//		return airportRepository.save(airport);
//	}
//
//	@Override
//	public Airport getAirportById(int id) {
//
//		return airportRepository.getOne(id);
//	}
//
//
//	@Override
//	public void delete(int id) {
//
//		airportRepository.deleteById(id);
//
//	}
//
//	public long count() {
//		return airportRepository.count();
//	}
//
//	@Override
//	public List<Airport> getAll(){
//		return airportRepository.findAll();
//	}
//
//
//
//}

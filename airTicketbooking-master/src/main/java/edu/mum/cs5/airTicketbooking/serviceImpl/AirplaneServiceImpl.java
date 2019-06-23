package edu.mum.cs5.airTicketbooking.serviceImpl;

import edu.mum.cs5.airTicketbooking.model.Airplane;
import edu.mum.cs5.airTicketbooking.repository.AirplaneRepository;
import edu.mum.cs5.airTicketbooking.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AirplaneServiceImpl implements AirplaneService {

	@Autowired
	private AirplaneRepository airplaneRepository;
	@Override
	public Airplane saveAirplane(Airplane airplane) {
		// TODO Auto-generated method stub
		return airplaneRepository.save(airplane);
	}

	@Override
	public List<Airplane> findAllAirplane() {
		// TODO Auto-generated method stub
		return airplaneRepository.findAll();
	}




//	@Override
//	public Airplane getAirplane(Long id) {
//		// TODO Auto-generated method stub
//		if(id != null)
//			return airplaneRepository.findById(id).get();
//		return null;
//	}

	@Override
	public Airplane getAirplane(Integer id) {
		return airplaneRepository.findById(id).get();
	}

	@Override
	public List<Airplane> findOrderedAirplane() {
		// TODO Auto-generated method stub
		return airplaneRepository.findAllByOrderByCapacityAsc();
	}
	


	@Override
	public void deletAirplane(Integer id) {
		// TODO Auto-generated method stub
		airplaneRepository.deleteById(id);
	}

	@Override
	public Airplane updateById(Integer id) {
		// TODO Auto-generated method stub
	Airplane airplane =	airplaneRepository.findById(id).get();
	return saveAirplane(airplane);
		
	}

}

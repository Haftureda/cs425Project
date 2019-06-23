package edu.mum.cs5.airTicketbooking.service;


import edu.mum.cs5.airTicketbooking.model.Airplane;

import java.util.List;


public interface AirplaneService {
	Airplane saveAirplane(Airplane airplane);
	List<Airplane> findAllAirplane();
	Airplane getAirplane(Integer id);
	void deletAirplane(Integer id);
	public List<Airplane> findOrderedAirplane();
	Airplane updateById(Integer id);
}

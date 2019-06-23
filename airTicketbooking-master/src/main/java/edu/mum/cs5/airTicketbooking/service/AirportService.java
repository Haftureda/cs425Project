package edu.mum.cs5.airTicketbooking.service;
import edu.mum.cs5.airTicketbooking.model.Airport;
import edu.mum.cs5.airTicketbooking.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public  class AirportService    {
    @Autowired
    AirportRepository airportRepository;

    public void save( Airport airport) {
         airportRepository.save(airport);
    }
    public List<Airport> searchAll() {
        return airportRepository.findAll();
    }

    public Airport findOne(Long id) {
        return airportRepository.getOne(id);
    }

    public long count() {
        return  airportRepository.count() ;
    }
    public void delete(long id) {
        airportRepository.deleteById(id);
    }
}

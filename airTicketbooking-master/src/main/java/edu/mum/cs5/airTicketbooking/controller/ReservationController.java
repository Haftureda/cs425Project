package edu.mum.cs5.airTicketbooking.controller;

import edu.mum.cs5.airTicketbooking.model.Airport;
import edu.mum.cs5.airTicketbooking.model.Schuedule;
import edu.mum.cs5.airTicketbooking.service.AirportService;
import edu.mum.cs5.airTicketbooking.service.SchueduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller


public class ReservationController {

    @Autowired
    private AirportService airportService;
    @Autowired
    SchueduleService schueduleService;

    @GetMapping(value = "/searchFlight")
    public String flightForm(Model model) {
        model.addAttribute("schuedule", new Schuedule());
        List<Airport> airports = airportService.searchAll();
        model.addAttribute("airports", airports);
        return "customer/searchFlight";
    }

//    //creating flight search method
//    @GetMapping(value ="/search")
//    public ModelAndView searchFlight(Schuedule s) {
//
//        System.out.print( "This is mukara  Frist to check  filled  information to search possible flight\n\n" + s.toString());
//        List<Schuedule> flights=  schueduleService.availableFlights(s);
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("flights", flights);
//        mv.setViewName("customer/availableFlightList");
//        return  mv;
//    }


    @PostMapping(value = "/search")
    public ModelAndView getAvalableFlightSchuedule(@Valid @ModelAttribute("schuedule") Schuedule schuedule) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("errors", bindingResult.getAllErrors());
//            List<Airport> airports = airportRepository.findAll();
//            model.addAttribute("airports", airports);
//            return "admin/addSchuedulingPage";
//        }

        System.out.print( "This is mukara  First to check  filled  information to search possible flight\n\n" +
                schuedule.toString());

        List<Schuedule> flights=  schueduleService.availableFlights(schuedule);

        ModelAndView mv = new ModelAndView();
        mv.addObject("flights", flights);
        mv.setViewName("customer/availableFlightList");
        return  mv;
//        schueduleService.SaveSchuedule(schuedule);
//        return "redirect:/admin/schueduleList";
    }

}

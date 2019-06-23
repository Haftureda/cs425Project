package edu.mum.cs5.airTicketbooking.controller;

import edu.mum.cs5.airTicketbooking.model.Airport;
import edu.mum.cs5.airTicketbooking.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.List;

@Controller
@ComponentScan
public class AirportController_aman {
    @Autowired
    AirportService airportService;
    @GetMapping(value="/newAirport")
    public String recordAirport(ModelMap model) {
        Airport airport = new Airport();
        model.addAttribute("airport",airport);
        return "admin/addairport";
    }
    @PostMapping(value="/saveAirport")
    public String saveRegistration(@Valid Airport airport, BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {
        airportService.save(airport);
        return "redirect:/airport/list";
    }
    @GetMapping(value = "/airport/list")
    public ModelAndView getAll() {
        List<Airport> airports = airportService.searchAll();
        return new ModelAndView("admin/airportList", "airports", airports);
    }


//    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
//    public String editsave(@ModelAttribute("airport") Airport ap) {
//        Airport airport = airportService.findOne(ap.getAirportCode());
//        airport.setAirportCode(ap.getAirportCode());
//        airport.setAirportName(ap.getAirportName());
//        airport.setCountry(ap.getCountry());
//        airportService.save(airport);
//        return  "redirect:/airport/list";
//    }
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String displayHomapage() {
//        return "index";
//    }
    @GetMapping(value = "/deleteairport/{id}")
    public String delete(@PathVariable("id") long id) {
        airportService.delete(id);
        return  "redirect:/airport/list";
    }

    @RequestMapping(value = "/editairport/{id}")
    public String edit(@PathVariable Long id, Model model) {

        Airport airport = airportService.findOne(id);
        model.addAttribute("airport", airport);
        return "admin/updateAirport-form";
    }



}

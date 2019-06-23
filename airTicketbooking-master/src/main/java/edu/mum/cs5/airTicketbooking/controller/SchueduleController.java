package edu.mum.cs5.airTicketbooking.controller;

import edu.mum.cs5.airTicketbooking.model.Airplane;
import edu.mum.cs5.airTicketbooking.model.Airport;
import edu.mum.cs5.airTicketbooking.model.Schuedule;
import edu.mum.cs5.airTicketbooking.repository.AirportRepository;
import edu.mum.cs5.airTicketbooking.service.AirplaneService;
import edu.mum.cs5.airTicketbooking.service.SchueduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SchueduleController {

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    SchueduleService schueduleService;

    @Autowired
    AirplaneService airplaneService;
    ////

    @GetMapping(value = "/newSchuedule")
    public String newProductForm(Model model) {
        model.addAttribute("schuedule", new Schuedule());
        List<Airport> airports = airportRepository.findAll();
        model.addAttribute("airports", airports);
        List<Airplane> airplanes = airplaneService.findAllAirplane();
        model.addAttribute("airplanes", airplanes);
        return "admin/newSchedule2";
    }

    @PostMapping(value = "/saveSchuedule")
    public String addNewProduct(@Valid @ModelAttribute("schuedule") Schuedule schuedule,
                                BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("errors", bindingResult.getAllErrors());
//            List<Airport> airports = airportRepository.findAll();
//            model.addAttribute("airports", airports);
//            return "admin/addSchuedulingPage";
//        }
      schueduleService.SaveSchuedule(schuedule);
        return "redirect:/admin/schueduleList";
    }

//    /////
//    @GetMapping(value="/newSchuedule")
//    public String recordingSchuedule(ModelMap model) {
//        Schuedule schuedule = new Schuedule();
//        model.addAttribute("schuedule",schuedule);
//        return "admin/addSchuedulingPage";
//    }
//    @PostMapping(value="/saveSchuedule")
//    public String saveSchuedule(@Valid Schuedule schuedule, BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {
//        schueduleService.SaveSchuedule(schuedule);
//        return "redirect:/admin/schueduleList";
//    }
//
//    @PostMapping(value="/saveSchuedule")
//    public String saveSchuedule(@Valid @ModelAttribute("schuedule") Schuedule schuedule ,BindingResult bindingResult , ModelMap model) {
//
//        if (bindingResult.hasErrors()) {
//            model.addAttribute( "errors", bindingResult.getAllErrors());
//            model.addAttribute("airports", airportRepository.findAll(Sort.by("airportCode")));
//
//        }
//
//        schueduleService.SaveSchuedule(schuedule);
//        return "redirect:/admin/schueduleList";
//    }
    @GetMapping(value = "/admin/schueduleList")
    public ModelAndView getAll() {
        List<Schuedule> schuedules = schueduleService.searchAllSchuedule();
        return new ModelAndView("admin/schueduleList", "schuedules", schuedules);
    }
//

    @GetMapping(value="/editschuedule/{id}")
    public String edit (@PathVariable Long id,Model model) {
        Schuedule schuedule=schueduleService.searchById(id);
        model.addAttribute("schuedule",schuedule);
        return "admin/editSchuedule";
    }

    @PostMapping(value = "/editsave")
    public String editsave(@ModelAttribute("schuedule") Schuedule p) {
        Schuedule schuedule = schueduleService.searchById(p.getId());
        schuedule.setDepartureAirport(p.getDepartureAirport());
        schuedule.setDepartureDate(p.getDepartureDate());
//        schuedule.setDepartureTime(p.getDepartureTime());
        schuedule.setArriavaleAirport(p.getArriavaleAirport());
//        schuedule.setArrivaleTime(p.getArrivaleTime());
        schuedule.setArrivaleaDate(p.getArrivaleaDate());
        schuedule.setPrice(p.getPrice());

        schueduleService.SaveSchuedule(schuedule);
        return "redirect:/admin/schueduleList";
    }

    @RequestMapping(value="/deleteschuedule/{id}",method=RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        schueduleService.deleteSchueduleById(id);
        return "redirect:/admin/schueduleList";
    }

//    @GetMapping(value = "/searchForm")
//    public String flightForm(Model model) {
//        model.addAttribute("schuedule", new Schuedule());
//        List<Airport> airports = airportRepository.findAll();
//        model.addAttribute("airports", airports);
//        return "customer/searchFlight";
//    }
//
////    //creating flight search method
////    @GetMapping(value ="/search")
////    public ModelAndView searchFlight(Schuedule s) {
////
////        System.out.print( "This is mukara  Frist to check  filled  information to search possible flight\n\n" + s.toString());
////        List<Schuedule> flights=  schueduleService.availableFlights(s);
////        ModelAndView mv = new ModelAndView();
////        mv.addObject("flights", flights);
////        mv.setViewName("customer/availableFlightList");
////        return  mv;
////    }
//
//
//    @PostMapping(value = "/search")
//    public ModelAndView getAvalableFlightSchuedule(@Valid @ModelAttribute("schuedule") Schuedule schuedule) {
////        if (bindingResult.hasErrors()) {
////            model.addAttribute("errors", bindingResult.getAllErrors());
////            List<Airport> airports = airportRepository.findAll();
////            model.addAttribute("airports", airports);
////            return "admin/addSchuedulingPage";
////        }
//
//        System.out.print( "This is mukara  First to check  filled  information to search possible flight\n\n" +
//                schuedule.toString());
//
//        List<Schuedule> flights=  schueduleService.availableFlights(schuedule);
//
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("flights", flights);
//        mv.setViewName("customer/availableFlightList");
//        return  mv;
////        schueduleService.SaveSchuedule(schuedule);
////        return "redirect:/admin/schueduleList";
//    }

}

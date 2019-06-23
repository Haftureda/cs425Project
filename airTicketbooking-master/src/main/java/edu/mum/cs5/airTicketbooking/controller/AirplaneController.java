package edu.mum.cs5.airTicketbooking.controller;

import edu.mum.cs5.airTicketbooking.model.Airplane;
import edu.mum.cs5.airTicketbooking.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AirplaneController {

    @Autowired
    //private AirplaneRepository airplaneRepository;
    private AirplaneService airplaneService;

    @GetMapping(value = "/list")
    public String getListOfAirplanes(Model model) {
        List<Airplane> planes = airplaneService.findAllAirplane();
        model.addAttribute("jets", planes);
        return "home/airplaneList";
    }

    //ordered list

    @GetMapping(value = "/orderedlist")
    public String getListOfOrderedAirplanes(Model model) {
        List<Airplane> planes = airplaneService.findOrderedAirplane();
        model.addAttribute("jets", planes);
        return "home/airplaneList";
    }


    //add a method to get the form data this is get mapping method
    @GetMapping(value = "/showForm")
    public String showFormForAdd(Model model) {
        Airplane plane = new Airplane();
        model.addAttribute("jets", plane);
        return "home/airplane-form";
    }

    //adding a method that saves the supplied data to the database
    @PostMapping(value = "/save")
    public String saveAirplane(@ModelAttribute("jets") Airplane airplane, BindingResult result) {
        if(result.hasErrors()) {
            return "error";
        }
        airplaneService.saveAirplane(airplane);
        return "redirect:/list";
    }

    @RequestMapping(value = "/edit{id}")
    public String edit(@ RequestParam("id") Integer id, Model model) {
        Airplane airplane = airplaneService.getAirplane(id);
        model.addAttribute(   "airplane",airplane);
        return  "home/updateForm";
    }

//    //adding a method that edits a list
//    @GetMapping(value = "/update{id}")
//    public String showFormForUpdate(@PathVariable(value = "id") Integer id, @Valid Airplane airplane, BindingResult result, Model model) {
//        if(result.hasErrors()) {
//            airplane.setId(id);
//            return "updateForm";
//        }
//        //get the airplane form the service
//        airplaneService.saveAirplane(airplane);
//
//        model.addAttribute("airplane", airplaneService.getAirplane(id));
//
//        return "home/updateForm";
//    }


    //deleteing airplane from the list
    @GetMapping(value ="delete/{id}")
    public String deleteAirplane(@PathVariable Integer id) {
        System.out.println("hi");
        airplaneService.deletAirplane(id);
        System.out.println(" after delete");
        return "redirect:/list";

    }


//    @RequestMapping(value="/deleteschuedule/{id}",method=RequestMethod.GET)
//    public String delete(@PathVariable Long id) {
//        schueduleService.deleteSchueduleById(id);
//        return "redirect:/admin/schueduleList";
//    }
//
}




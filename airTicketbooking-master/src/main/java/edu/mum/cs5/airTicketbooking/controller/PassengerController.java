package edu.mum.cs5.airTicketbooking.controller;

import edu.mum.cs5.airTicketbooking.model.Passenger;
import edu.mum.cs5.airTicketbooking.model.Schuedule;
import edu.mum.cs5.airTicketbooking.service.PassengerService;
import edu.mum.cs5.airTicketbooking.service.ReservationService;
import edu.mum.cs5.airTicketbooking.service.SchueduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PassengerController {

	@Autowired
	private PassengerService passengerServiceImpl;
//	private ReservationService reservationService;
	@Autowired
	private SchueduleService schueduleService;
private  ReservationService reservationService;

	//
//	ModelAndView mv = new ModelAndView();
////        mv.addObject("flights", flights);
////        mv.setViewName("customer/availableFlightList");
////


	//updating passenger information
	@GetMapping("/newBooking/{id}")
	public ModelAndView newBookingForm(@PathVariable(name="id") long id) {

		System.out.println("\n\n  transferred  values of  selected Schuedule " + id);
		Passenger passenger=  new Passenger();
		Schuedule schuedule = schueduleService.searchById(id);
		ModelAndView mav=new ModelAndView("customer/passenger/addNewPassenger");
		mav.addObject("passenger", passenger);
		mav.addObject("schuedule",schuedule);
		return mav;
	}

	//saving new passenger
	@PostMapping("/savePassenger")
	public String saveAirport(@Valid @ModelAttribute("passenger") Passenger passenger,
							  BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("error", result.getAllErrors());
			return "customer/passenger/addNewPassenger";
		}
		//save the passenger
		passengerServiceImpl.addNewPassenger(passenger);

		// use a redirect to prevent duplicate submission
		return "customer/passenger/bookingConfirmationPage";
	}


	//
//	//showing list of passengers
//	@GetMapping(value="/list")
//	public ModelAndView listofPassengers() {
//		ModelAndView mav= new ModelAndView();
//		List<Passenger> passengers=passengerServiceImpl.getPassenger();
//		mav.addObject("passengers", passengers);
//		mav.setViewName("passenger/listOfPassengers");
//
//		return mav;
//	}
	//adding new passenger


//	@PostMapping(value = "/newBooking/{id}")
//	public String addNewProduct(@Valid @ModelAttribute("schuedule") Schuedule schuedule,
//								BindingResult bindingResult, Model model) {
////        if (bindingResult.hasErrors()) {
////            model.addAttribute("errors", bindingResult.getAllErrors());
////            List<Airport> airports = airportRepository.findAll();
////            model.addAttribute("airports", airports);
////            return "admin/addSchuedulingPage";
////        }
//		schueduleService.SaveSchuedule(schuedule);
//		return "redirect:/admin/schueduleList";
//	}


	////
//	@GetMapping("/newBooking/{id}")
//	public ModelAndView bookingForm(@PathVariable(name="id") Long id) {
////	public String bookingForm(Model model) {
//		Schuedule schuedule=  schueduleService.searchById(id);
//		Passenger passenger=new Passenger();
//		ModelAndView passModel= new ModelAndView();
//		passModel.addAttribute("passenger", passenger);
//
//		mv.setViewName("customer/availableFlightList");
//		return  mv;
//
//		return  "passenger/addNewPassenger";
//	}

//	//updating passenger information
//	@GetMapping("/newBooking/{id}")
//	public ModelAndView updatePassenger(@PathVariable(name="id") int id) {
//		Passenger passenger=passengerServiceImpl.updatePassenger(id);
//		ModelAndView mav=new ModelAndView("passenger/updatePassenger-form");
//		mav.addObject("passenger", passenger);
//		return mav;
//
//	}
//	@GetMapping("/delete/{id}")
//	public String deletePassenger(@PathVariable("id") int id) {
//		passengerServiceImpl.delete(id);
//		return "redirect:/list";
//	}

}

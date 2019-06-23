package edu.mum.cs5.airTicketbooking.controller;

import java.util.List;

import edu.mum.cs5.airTicketbooking.model.CrewMember;
import edu.mum.cs5.airTicketbooking.service.CrewMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CrewMemberController {
	@Autowired
    private CrewMemberService service;
	
	@GetMapping(value= {"/elibrary-web","/elibrary-web/home"})
	public String viewHomePage(Model model) {
	    List<CrewMember> bookList = service.getBooks();
	    model.addAttribute("bookList",  bookList);
	      return "home/index";
	}
	@GetMapping(value="/new")
	public String insertNewBookForm(Model model) {
	    CrewMember book = new CrewMember();
	    model.addAttribute("book", book);
	     
	    return "home/newbookform";
	}
	@PostMapping(value = "/addCrew")
	public String saveBook(@ModelAttribute("book") CrewMember book) {
	    service.saveBook(book);
	    return "redirect:/elibrary-web";
	}

	@RequestMapping("/editCrew/{id}")
	public ModelAndView showEditBookForm(@PathVariable(name = "id") int id) {
		CrewMember book = service.getBook(id);
	    ModelAndView mav = new ModelAndView("home/editbookform");    
	    mav.addObject("book", book);//    
	     
	    return mav;
	}
	
	@RequestMapping("/deleteCrew/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
	    service.deleteBook(id);
		return "redirect:/elibrary-web";
	}
}

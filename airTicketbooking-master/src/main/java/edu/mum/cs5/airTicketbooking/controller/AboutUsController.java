package edu.mum.cs5.airTicketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@ComponentScan
public class AboutUsController {
    @Autowired

    @GetMapping(value = "/c")
    public  String displayCommonHomepage(){
        return "customer/index";
    }
//    @GetMapping(value = "/c")
//    public  String displayCustomerHomepage(){
//        return "customer/index";
//    }

    @GetMapping(value = "/cbb")
    public  String displaybook(){
        return "admin/book";
    }


    @GetMapping(value = "/")
    public  String displayHomepage(){
        return "admin/index123";
   }



//    @GetMapping(value = "/newdate")
//    public  String myDatinfo(){
//        return "admin/myDate";
//    }
//    @PostMapping(value = "/addnewdate")
//    public  String addmyDatinfo(){
//
//        return "admin/MyDate";
//    }

}

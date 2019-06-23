package edu.mum.cs5.airTicketbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class AirTicketbookingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirTicketbookingSystemApplication.class, args);
	}

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}


}

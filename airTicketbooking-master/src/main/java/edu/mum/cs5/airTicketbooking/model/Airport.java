package edu.mum.cs5.airTicketbooking.model;

import javax.persistence.*;

@Entity
public class Airport {
    public long getId() {
        return id;
    }
    public Airport(String airportCode, String airportName, String city, String country) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.city = city;
        this.country = country;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Airport(String airportName, String city, String country) {
        this.airportName = airportName;
        this.city = city;
        this.country = country;
    }
    public Airport() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
//    @Column(name = "airport_code",unique=true,columnDefinition="VARCHAR(10)")
    private String airportCode;

    public String getAirportCode() {
        return airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    private String airportName;

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String city;
    private String country;

}

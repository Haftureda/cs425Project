package edu.mum.cs5.airTicketbooking.model;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Schuedule {
    public Integer getPlaneId() {
        return planeId;
    }
    public void setPlaneId(Integer planeId) {
        this.planeId = planeId;
    }

    public void setPlaneNumber(Integer planeNumber) {
        this.planeNumber = planeNumber;
    }
    public Integer getPlaneNumber() {
        return planeNumber;
    }

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private  long id;

    public Schuedule(Integer planeId, Integer planeNumber, LocalDate departureDate, @NotNull(message = "Arriavel date is required ") LocalDate arrivaleaDate, String departureAirport, @NotNull(message = "Arriavel date is required ") @NotBlank(message = "arrivate date should not be empty") String arriavaleAirport, @NotNull(message = "* Unit Price is required") @Digits(integer = 9, fraction = 2, message = "*  Price must be a numeric/monetary amount in decimal (money) format as 'xxx.xx'") float price) {
        this.planeId = planeId;
        this.planeNumber = planeNumber;
        this.departureDate = departureDate;
        this.arrivaleaDate = arrivaleaDate;
        this.departureAirport = departureAirport;
        this.arriavaleAirport = arriavaleAirport;
        this.price = price;
    }

    private Integer planeId;
    private Integer planeNumber;

    public Schuedule() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setArrivaleaDate(LocalDate arrivaleaDate) {
        this.arrivaleaDate = arrivaleaDate;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setArriavaleAirport(String arriavaleAirport) {
        this.arriavaleAirport = arriavaleAirport;
    }


//    @NotNull(message = "departure date is required")
     @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public long getId() {
        return id;
    }



    public LocalDate getArrivaleaDate() {
        return arrivaleaDate;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArriavaleAirport() {
        return arriavaleAirport;
    }
//
    @NotNull(message = "Arriavel date is required ")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate arrivaleaDate;

//    @NotNull(message = "Arrivale date is required ")
//    private Time departureTime;
//    @NotNull(message = "Arriavel date Time is required ")
//    private Time arrivaleTime;
//    @NotNull(message = "Arriavel date is required ")
    private  String  departureAirport;

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    @NotNull(message = "Arriavel date is required ")
    @NotBlank(message = "arrivate date should not be empty")
    private  String  arriavaleAirport;

    @NotNull(message = "* Unit Price is required")
    @Digits(integer = 9, fraction = 2, message = "*  Price must be a numeric/monetary amount in decimal (money) format as 'xxx.xx'")
    @NumberFormat(pattern = "#,###.##")
    private  float  price;

    @Override
    public String toString() {
        return "Schuedule{" +
                "id=" + id +
                ", departureDate=" + departureDate +
                ", arrivaleaDate=" + arrivaleaDate +
                ", departureAirport='" + departureAirport + '\'' +
                ", arriavaleAirport='" + arriavaleAirport + '\'' +
                ", price=" + price +
                '}';
    }
}

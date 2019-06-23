package edu.mum.cs5.airTicketbooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private   long reservationId;
    private int passengerId;

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public long getReservationId() {
        return reservationId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    private String referenceNumber;

    public int getSchueduleId() {
        return schueduleId;
    }

    public void setSchueduleId(int schueduleId) {
        this.schueduleId = schueduleId;
    }

    private LocalDate bookingDate;
    private int schueduleId;

    public Reservation() {
    }

    public Reservation(int passengerId, String referenceNumber, LocalDate bookingDate, int schueduleId) {
        this.passengerId = passengerId;
        this.referenceNumber = referenceNumber;
        this.bookingDate = bookingDate;
        this.schueduleId = schueduleId;
    }
    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", passengerId=" + passengerId +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", bookingDate=" + bookingDate +
                '}';
    }
}

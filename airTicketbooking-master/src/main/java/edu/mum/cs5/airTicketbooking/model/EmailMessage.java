//package edu.mum.cs5.airTicketbooking.model;
//
//import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.validation.constraints.NotNull;
//import java.time.LocalDate;
//
//@Entity
//public class EmailMessage {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private  int emialId;
//    @NotNull
//    private  String from;
//    @NotNull
//    private String to;
//    @NotNull
//    private  String message;
//
//
//    public EmailMessage() {
//    }
//
//    public void setEmialId(int emialId) {
//        this.emialId = emialId;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public EmailMessage(@NotNull String from, @NotNull String to, @NotNull String message, LocalDate date, String status) {
//        this.from = from;
//        this.to = to;
//        this.message = message;
//        this.date = date;
//        this.status = status;
//    }
//
//    public void setFrom(String from) {
//        this.from = from;
//    }
//
//    public void setTo(String to) {
//        this.to = to;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
//
//    private LocalDate date;
//
//    public int getEmialId() {
//        return emialId;
//    }
//
//    public String getFrom() {
//        return from;
//    }
//
//    public String getTo() {
//        return to;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public EmailMessage(String from, String to, String message, LocalDate date) {
//        this.from = from;
//        this.to = to;
//        this.message = message;
//        this.date = date;
//    }
//    private String status;
//
//}

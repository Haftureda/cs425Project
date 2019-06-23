package edu.mum.cs5.airTicketbooking.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

@Entity
@Table(name="Passenger")
public class Passenger {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="passengerName")
	private String passengerName;
	
	
	@Column(name="passengerLastName")
	private String passengerLastName;
	
	
	@Column(name="passengerId")
	private int passengerId;
	
	@Column(name="sex")
	private String sex;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate date;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	public Passenger() {
		
	}

	public Passenger(String passengerName, String passengerLastName, int passengerId, String sex,
                     LocalDate date, String email, String phone) {
		super();
		this.passengerName = passengerName;
		this.passengerLastName = passengerLastName;
		this.passengerId = passengerId;
		this.sex = sex;
		this.date = date;
		this.email = email;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerLastName() {
		return passengerLastName;
	}

	public void setPassengerLastName(String passengerLastName) {
		this.passengerLastName = passengerLastName;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", passengerName=" + passengerName + ", passengerLastName=" + passengerLastName
				+ ", passengerId=" + passengerId + ", sex=" + sex + ", date=" + date + ", email=" + email + ", phone="
				+ phone + "]";
	}
	
	
	
	
	
	
	
}

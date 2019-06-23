package edu.mum.cs5.airTicketbooking.model;

import javax.persistence.*;

@Entity
@Table(name = "Airplanes")
public class Airplane {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="plane_id", unique = true)
	private Integer id;
	
	@Column( unique = true)
	private Integer planeNumber;
	private String model;
	private String make;
	private Integer capacity;
	//private List<CrewMember> crewMember = new ArrayList<>();
	
	//constructors
	public Airplane() {
		
	}
	public Airplane(Integer planeNumber, String model, String make, Integer capacity) {
		this.planeNumber = planeNumber;
		this.model = model;
		this.make = make;
		this.capacity = capacity;
	}
	
	//getters and setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer planeId) {
		this.id = planeId;
	}
	public Integer getPlaneNumber() {
		return planeNumber;
	}
	public void setPlaneNumber(Integer planeNumber) {
		this.planeNumber = planeNumber;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	
	//to string method
	@Override
	public String toString() {
		return "Airplane [id=" + id + ", planeNumber=" + planeNumber + ", model=" + model + ", make=" + make
				+ ", capacity=" + capacity + "]";
	}
	

	
}

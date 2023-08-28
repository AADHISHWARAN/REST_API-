package com.example.swagger.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="gardenmodel")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int plantId;
	@Column(name="gardenname")
	private String plantName;
	private String Seeds;
	private String GardenTools;
	private String city;
	private String state;
	private String country;
	public int getPlantId() {
		return plantId;
	}
	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	public String getSeeds() {
		return Seeds;
	}
	public void setSeeds(String seeds) {
		Seeds = seeds;
	}
	public String getGardenTools() {
		return GardenTools;
	}
	public void setGardenTools(String gardenTools) {
		GardenTools = gardenTools;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}

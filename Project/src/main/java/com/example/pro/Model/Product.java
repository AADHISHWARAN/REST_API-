package com.example.pro.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
@Entity
@Table(name="products")

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="plantname")
	private String name;
	private String plant;
	private String description;
	private double price;
	private int stock;
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id=id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name=name;
	}
	public String getplant() {
		return plant;
	}
	public void getplant(String plant) {
		this.plant=plant;
	}
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description=description;
	}
	public double getprice() {
		return price;
	}
	public void setprice(double price) {
		this.price=price;
	}
	public int getstock() {
		return stock;
	}
	public void setstock(int stock) {
		this.stock=stock;
	}
	public void updateFrom(Product updatedProduct) {
		// TODO Auto-generated method stub
		
	}
}
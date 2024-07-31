package com.example.exam3.model;

import jakarta.persistence.*;


@Entity
@Table(name="gadgets")
public class gadgets 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String brand;
	private String category;
	private double price;
	private String imageFileName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public gadgets(int id, String name, String brand, String category, double price, String imageFileName) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.price = price;
		this.imageFileName = imageFileName;
	}
	public gadgets() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "gadgets [id=" + id + ", name=" + name + ", brand=" + brand + ", category=" + category + ", price="
				+ price + ", imageFileName=" + imageFileName + "]";
	}
	
	
	
}

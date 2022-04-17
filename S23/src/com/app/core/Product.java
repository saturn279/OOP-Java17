package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;

public class Product implements Serializable {

	private int id;
	private String name;
	private double price;
	private LocalDate expiryDate;
	private static int count;

	public Product(String name, double price, LocalDate expiryDate) {
		super();
		this.id = count++;
		this.name = name;
		this.price = price;
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", expiryDate=" + expiryDate + "]\n";
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

}

package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;

import com.app.core.Product;
import com.app.custom_exceptions.DuplicateEntry;
import com.app.custom_exceptions.ExpiredProduct;

public class ProductValidations {

	/**
	 * ensures user entries follow validation rules
	 * 
	 * @return new validated Product
	 */
	public static Product validateProduct(String name, double price, LocalDate expiryDate,
			ArrayList<Product> productList) throws Exception {

		checkForDuplicates(name, price, productList);
		return new Product(name, price, validateExpiryDate(expiryDate));
	}

	/**
	 * Check for duplicate by comparing name and price with existing products
	 * 
	 * @throws DuplicateEntry
	 */
	public static void checkForDuplicates(String name, double price, ArrayList<Product> productList)
			throws DuplicateEntry {
		if (productList.stream().filter(p -> p.getName().equals(name) && p.getPrice() == price).count() > 0)
			throw new DuplicateEntry();
	}

	/**
	 * Checks if expiryDate has already passed.
	 * 
	 * @param expiryDate
	 * @return validated expiryDate
	 * @throws ExpiredProduct
	 */
	public static LocalDate validateExpiryDate(LocalDate expiryDate) throws ExpiredProduct {
		if (expiryDate.isAfter(LocalDate.now()))
			return expiryDate;
		else
			throw new ExpiredProduct();
	}

}

package com.app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.app.core.Product;

public class IOUtils {

	/**
	 * Stores productList into a file
	 * 
	 */
	public static void saveTofile(ArrayList<Product> productList, String fileName) throws Exception {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));) {
			out.writeObject(productList);
		}
	}

	/**
	 * Gets product list from the file and validates each entry.
	 * 
	 * @return list of validated products.
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Product> getFromFile(String fileName) throws Exception {
		File productsFile = new File(fileName);
		if (productsFile.exists()) {
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(productsFile))) {
				ArrayList<Product> productList = new ArrayList<Product>();
				for (Product p : (ArrayList<Product>) in.readObject()) {
					productList.add(ProductValidations.validateProduct(p.getName(), p.getPrice(), p.getExpiryDate(),
							productList));
				}
				return productList;
			}
		}
		return new ArrayList<Product>();
	}
}
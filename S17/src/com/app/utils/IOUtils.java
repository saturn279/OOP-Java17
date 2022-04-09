package com.app.utils;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import com.app.core.Product;

public interface IOUtils {
	@SuppressWarnings("unchecked")
	/**
	 * If Products binary exists, reads and returns map object from the file, else
	 * return empty map.
	 * 
	 * 
	 * @return Map<Integer, Product>
	 * @throws Exception
	 */
	static Map<Integer, Product> restoreProductDetails() throws Exception {

		String fileName = "Products.ser";
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			return (Map<Integer, Product>) in.readObject();
		} catch (Exception e) {
			return new HashMap<Integer, Product>();
		}
	}

}

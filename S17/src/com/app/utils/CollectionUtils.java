package com.app.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.app.core.Product;

public interface CollectionUtils {

	/**
	 * returns List containing values of provided Map
	 * 
	 * @param Map<Integer,Product> productMap
	 * @return List<Product>
	 * @throws Exception
	 */
	static List<Product> listFromMap(Map<Integer, Product> productMap) throws Exception {
		List<Product> productArray = new ArrayList<Product>();
		productMap.forEach((i, product) -> productArray.add(product));
		return productArray;

	}
}

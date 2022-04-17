package com.app.tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.core.Product;
import com.app.custom_exceptions.ProductNotFound;
import com.app.utils.IOUtils;
import com.app.utils.ProductValidations;

class TestProduct {

	public static void main(String[] args) throws Exception {

		ArrayList<Product> productList = IOUtils.getFromFile("Products.ser");
		Boolean exit = false;
		try (Scanner sc = new Scanner(System.in)) {

			do {
				try {
					System.out.println(
							"1.Display All Product entries.\n2.Add new product entry\n3.Remove product entries by name.\n4.Save and Exit\n\tChoose option: ");
					;
					int choice = sc.nextInt();

					switch (choice) {
					case 1:
						System.out.println(productList);
						break;
					case 2:
						System.out.println("Enter product name, price, expireDate [String Double yyyy-MM-dd]: ");
						productList.add(ProductValidations.validateProduct(sc.next(), sc.nextDouble(),
								LocalDate.parse(sc.next()), productList));
						System.out.println("Product added.");
						break;
					case 3:
						System.out.println("Enter product name [String]: ");
						String name = sc.next();
						if (productList.removeIf(p -> p.getName().equals(name)))
							System.out.println("Product removed.");
						else
							throw new ProductNotFound(name);
						break;
					case 4:
						IOUtils.saveTofile(productList, "Products.ser");
						exit = true;
						break;
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				sc.nextLine();

			} while (!exit);
		}
	}
}

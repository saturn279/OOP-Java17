package com.app.tester;

import static com.app.utils.CollectionUtils.*;
import static com.app.utils.IOUtils.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

import com.app.core.Category;
import com.app.core.Product;
import com.app.utils.MenuHandler;

public class TestProduct {
    public static void main(String args[]) {

        try (Scanner sc = new Scanner(System.in)) {
            boolean quit = false;
            Map<Integer, Product> productMap = (HashMap<Integer, Product>) restoreProductDetails();
            MenuHandler menu = new MenuHandler("Add new product", "Display all products",
                    "List products of specific category", "Remove product details", "Quit");

            do {
                try {
                    switch (menu.chooseOption(sc)) {
                        case 1:
                            System.out.print("\nEnter product id: ");
                            int id = sc.nextInt();

                            if (productMap.containsKey(id)) {

                                System.out.println("Product with given Id already exist.");
                            } else {
                                System.out.print(
                                        "\nEnter name, productCatgeory, manufactureDate, price : ");

                                productMap.putIfAbsent(id,
                                        new Product(id, sc.next(), Category.valueOf(sc.next().toUpperCase()),
                                                LocalDate.parse(sc.next()), sc.nextDouble()));
                                System.out.println("Product added.");
                            }

                            break;
                        case 2:
                            productMap.forEach((i, product) -> System.out.println(product));
                            break;
                        case 3:
                            System.out.print("\nEnter Product Category: ");
                            String productCategory = sc.next();
                            List<Product> productArray = listFromMap(productMap);
                            Predicate<Product> getProductsByCategory = product -> product.getProductCategory()
                                    .toString().equals(productCategory.toUpperCase());
                            Comparator<Product> compareProductsByDate = (productI, ProductJ) -> productI
                                    .getManufactureDate().compareTo(ProductJ.getManufactureDate());
                            productArray.stream().filter(getProductsByCategory).sorted(compareProductsByDate)
                                    .forEach(product -> System.out.println(product));
                            break;
                        case 4:
                            System.out.print("\nEnter Product Id: ");
                            if (productMap.remove(sc.nextInt()).equals(null))
                                System.out.println("No product associated with given Id.");
                            else
                                System.out.println("Product Deleted");
                            break;
                        case 5:
                            quit = true;
                            break;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    ;
                }
                sc.nextLine();
            } while (!quit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

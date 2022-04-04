package tester;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.app.core.*;
import static utils.CollectionUtils.populateData;

public class TestProduct {

  public static void main(String args[]) {
    List<Product> productArray = populateData();
    productArray.forEach(new Consumer<Product>() { //printing entire List
      @Override
      public void accept(Product product) {
        System.out.println(product);
      }
    });



    System.out.println("\nRemoved catergory FRUITS");
    productArray.removeIf(new Predicate<Product>() { //Anonymous class implementing Predicate 
      @Override 
      public boolean test(Product product) {
        return product.getProductCatgeory().toString().equals("FRUITS");
      }
    });
    productArray.forEach(new Consumer<Product>() { //printing entire List
      @Override
      public void accept(Product product) {
        System.out.println(product);
      }
    });
    
    
    System.out.println("\nSorted in Ascending by price");
    Collections.sort(productArray, new Comparator<Product>(){ //Anonymous class implementing Comperator 
      @Override
      public int compare(Product product1, Product product2) {
       return ((Double)product1.getPrice()).compareTo((Double)product2.getPrice());
      }      
    });
    productArray.forEach(new Consumer<Product>() { //printing entire List
      @Override
      public void accept(Product product) {
        System.out.println(product);
      }
    });
  }
}

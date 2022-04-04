package tester;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.app.core.*;

import utils.ProductComperator;
import utils.ProductConsumer;
import utils.ProductPredicate;

import static utils.CollectionUtils.populateData;

public class TestProduct {

  public static void main(String args[]) {
    List<Product> productArray = populateData();
    productArray.forEach(new ProductConsumer());



    System.out.println("\nRemoved catergory FRUITS");
    productArray.removeIf(new ProductPredicate());
    productArray.forEach(new ProductConsumer());


    
    System.out.println("\nSorted in Ascending by price");
    Collections.sort(productArray, new ProductComperator());
    productArray.forEach(new ProductConsumer());


  }
}

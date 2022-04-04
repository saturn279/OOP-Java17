package utils;

import java.util.Comparator;

import com.app.core.Product;

public class ProductComperator implements Comparator{

    @Override
    public int compare(Object productObject1, Object productObject2) {
        return ((Double)(((Product)productObject1).getPrice())).compareTo((Double)(((Product)productObject2).getPrice()));

        
    }
   
}

package utils;

import java.util.function.Predicate;

import com.app.core.Product;

public class ProductPredicate implements Predicate {

    @Override
    public boolean test(Object product) {
        return ((Product)product).getProductCatgeory().toString().equals("FRUITS");
   
        
    }
    
}

package utils;

import java.util.function.Consumer;

import com.app.core.Product;

public class ProductConsumer implements Consumer{

    @Override
    public void accept(Object productObject) {
       System.out.println((Product)productObject);
        
    }
    
}

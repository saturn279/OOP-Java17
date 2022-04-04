package tester;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.app.core.*;
import static utils.CollectionUtils.populateData;
public class TestProduct {
    
    public static void main(String args[]) {
       List<Product> productArray = populateData();
       productArray.forEach(product -> System.out.println(product));
       System.out.println("\nRemoved catergory FRUITS ");
       productArray.removeIf(product -> product.getProductCatgeory().toString().equals("FRUITS") );
       productArray.forEach(product -> System.out.println(product));
       System.out.println("\nSorted by ascending price");
       Collections.sort(productArray,(productI,productJ) -> ((Double)productI.getPrice()).compareTo(((Double)productJ.getPrice())));
      productArray.forEach(product -> System.out.println(product));
   
    }
}

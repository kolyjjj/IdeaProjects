package Main;

import Parse.CartListParse;
import Parse.Parser;
import javafx.util.Pair;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by arolla on 14-12-11.
 */
public class ParseAndTidyCart {
    List<Pair<String,Integer>> cartList;
    Map<String,Integer> cartMap = new HashMap<String,Integer>() ;

    ParseAndTidyCart( List<Pair<String,Integer>> _cartList){
        cartList = _cartList;
    }
    ParseAndTidyCart(String _cartTxtPath) throws IOException {
        Parser cartListParse = new CartListParse(_cartTxtPath);
        cartList = cartListParse.parser(cartListParse.bufferedReader);

    }
    public void tidyCart(){

        for(Pair<String,Integer> lines:cartList){

            if (lines == null) break;

            if (!cartMap.containsKey(lines.getKey()))
                cartMap.put(lines.getKey(),lines.getValue());
            else
            {
                int i = cartMap.get(lines.getKey());
                cartMap.put(lines.getKey(),lines.getValue()+i);
            }

        }
    }
}

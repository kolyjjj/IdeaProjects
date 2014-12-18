package Main;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by arolla on 14-12-11.
 */
public class Cart {



    Map<Item, Integer> cartMap = new HashMap<Item, Integer>();
    public void setCartMap(Map<Item, Integer> cartMap) {
        this.cartMap = cartMap;
    }

    public void tidyCart(List<Pair<String, Integer>> cartList, List<Pair<String, Double>> priceList) {

        for (Pair<String, Double> pair : priceList) {

            if (pair == null) break;

            int itemNum = 0;

            for (Pair<String, Integer> lines : cartList) {
                if (lines.getKey().equals(pair.getKey())) {
                    itemNum += lines.getValue();
                }

            }

            cartMap.put(new Item(pair.getKey(), pair.getValue()), itemNum);
        }


    }

}

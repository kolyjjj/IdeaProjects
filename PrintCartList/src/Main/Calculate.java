package Main;

import Promotions.Promotion;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by arolla on 14-12-17.
 */
public class Calculate {
    List<Item> itemListBeforeHandling = new LinkedList<Item>();
    List<Item> itemListAfterHandling = new LinkedList<Item>();

    public void calculate(Map<Item,LinkedList<Promotion>> itemsWithPromotions){

       for (Item item :itemsWithPromotions.keySet()){
            Item item0,item1;
            LinkedList<Promotion> promotionList;

            item0 = new Item(item.getId(),item.getPrice());
            item1 = new Item(item.getId(),item.getPrice());

            itemListBeforeHandling.add(item0);

            promotionList = itemsWithPromotions.get(item);

            for (Promotion p : promotionList){
                if(p == null) break;
                p.promotion(item1);
            }

            itemListAfterHandling.add(item1);
        }
    }
}

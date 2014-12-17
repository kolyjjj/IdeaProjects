package Main;

import Promotions.OffXForEachY;
import Promotions.Promotion;
import Promotions.SecondHalfPrice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by arolla on 14-12-17.
 */
public class PutPromotionStrategiesToItemsOfCart {


    private Map<Item,LinkedList<Promotion>> itemsWithPromotions = new HashMap<Item, LinkedList<Promotion>>();

    public Map<Item, LinkedList<Promotion>> getItemsWithPromotions() {
        return itemsWithPromotions;
    }

    public void handleCartWithPromotions(Cart cart,PromotionDocument promotionDocument){

        promotionDocument.listToMap();

        for (Item o : cart.cartMap.keySet()) {
            //Map.Entry<Item, Integer> entry = (Map.Entry) o;

            if (promotionDocument.discountPromotionMap.containsKey(o.getId())) {
                if (!itemsWithPromotions.containsKey(o)) {
                    itemsWithPromotions.put(o, new LinkedList<Promotion>());
                }
                itemsWithPromotions.get(o).add(promotionDocument.discountPromotionMap.get(o.getId()));

            }


            if (promotionDocument.secondHalfPricePromotionMap.containsKey(o.getId())) {

                if (!itemsWithPromotions.containsKey(o)) {
                    itemsWithPromotions.put(o, new LinkedList<Promotion>());
                }
                SecondHalfPrice s = promotionDocument.secondHalfPricePromotionMap.get(o.getId());
                s.setNum(cart.cartMap.get(o));
                itemsWithPromotions.get(o).add(s);
            }

            if (promotionDocument.offXForEachYListMap.containsKey(o.getId())) {
                if (!itemsWithPromotions.containsKey(o)) {
                    itemsWithPromotions.put(o, new LinkedList<Promotion>());
                }
                OffXForEachY of = promotionDocument.offXForEachYListMap.get(o.getId());
                of.setNum(cart.cartMap.get(o));
                of.setX(5);
                of.setY(100);
                itemsWithPromotions.get(o).add(of);
            }


        }
    //    System.out.println(itemsWithPromotions.size());


    }

}

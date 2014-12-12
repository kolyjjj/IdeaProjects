package Main;

import MyException.MyException;
import Promotions.Discount;
import Promotions.OffXForEachY;
import Promotions.SecondHalfPrice;

import java.util.*;

/**
 * Created by arolla on 14-12-11.
 */
public class HandleCartWithPromotionStrategies {

    ParsePromotionDocument promotionDocument ;
    Map<String,Integer> cartMap = new HashMap<String,Integer>() ;
    List<Item> itemListBeforeHandling = new LinkedList<Item>();
    List<Item> itemListAfterHandling = new LinkedList<Item>();


    public void setPromotionDocument(ParsePromotionDocument promotionDocument) {
        this.promotionDocument = promotionDocument;
    }
    public void setCartMap(Map<String, Integer> cartMap) {
        this.cartMap = cartMap;
    }


    public void handleCart() throws MyException {
    Iterator e = cartMap.entrySet().iterator();
    while(e.hasNext()){

        Map.Entry entry = (Map.Entry) e.next();

        Item item = new Item(entry.getKey().toString(), promotionDocument.itemPriceMap.get(entry.getKey().toString()));
        itemListBeforeHandling.add(item);

        Item item2 = new Item(entry.getKey().toString(), promotionDocument.itemPriceMap.get(entry.getKey().toString()));
        if (promotionDocument.discountPromotionMap.containsKey(item2.getId()))
            item2 = new Discount().discount(item2, promotionDocument.discountPromotionMap.get(entry.getKey().toString()));
        if (promotionDocument.secondHalfPricePromotionList.contains(item2.getId()))
            item2 = new SecondHalfPrice().secondHalfPrice(item2, cartMap.get(entry.getKey().toString()));
        if (promotionDocument.offXForEachYList.contains(item2.getId()))
            item2 = new OffXForEachY().offXForEachY(item2, cartMap.get(entry.getKey().toString()), 5, 100);

        itemListAfterHandling.add(item2);

    }

    }


}

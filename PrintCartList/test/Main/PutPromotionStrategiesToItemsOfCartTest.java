package Main;

import Promotions.Discount;
import Promotions.OffXForEachY;
import Promotions.SecondHalfPrice;
import javafx.util.Pair;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class PutPromotionStrategiesToItemsOfCartTest {

    @Test
    public void testHandleCartWithPromotions() throws Exception {
       // Cart cart,PromotionDocument promotionDocument
        Cart cart = new Cart();
        Map<Item, Integer> cartMap = new HashMap<Item, Integer>();
        cartMap.put(new Item("ITEM000001",40.0),5);
        cart.setCartMap(cartMap);
        PromotionDocument promotionDocument = new PromotionDocument();
        Discount discount = new Discount();
        discount.setDiscount(0.75);
        promotionDocument.discountPromotionList.add(new Pair<String, Discount>("ITEM000001",discount));
        SecondHalfPrice secondHalfPrice = new SecondHalfPrice();
        promotionDocument.secondHalfPricePromotionList.add(new Pair<String, SecondHalfPrice>("ITEM000001", secondHalfPrice));
        OffXForEachY offXForEachY = new OffXForEachY();
        promotionDocument.offXForEachYList.add(new Pair<String, OffXForEachY>("ITEM000001",offXForEachY));
        PutPromotionStrategiesToItemsOfCart p = new PutPromotionStrategiesToItemsOfCart();

        p.handleCartWithPromotions(cart,promotionDocument);
        Iterator<Item> i = p.getItemsWithPromotions().keySet().iterator();
        Item j = i.next();

        assertTrue(j.equals(new Item("ITEM000001",40.0)));
        assertTrue(p.getItemsWithPromotions().get(j).get(0).equals(discount));
        assertTrue(p.getItemsWithPromotions().get(j).get(1).equals(secondHalfPrice));
        assertTrue(p.getItemsWithPromotions().get(j).get(2).equals(offXForEachY));





    }
}
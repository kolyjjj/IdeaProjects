package Main;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HandleCartWithPromotionStrategiesTest {
    @Test
    public void should_get_correct_itemListAfterHandling_when_use_method_handleCart() throws Exception {
        PromotionDocument promotionDocument = new PromotionDocument();
        Map<String,Double> discountPromotionMap = new HashMap<String, Double>();
        List<String> secondHalfPricePromotionList = new LinkedList<String>();
        List<String> offXForEachYList = new LinkedList<String>();
        Map<String,Double> itemPriceMap = new HashMap<String, Double>();
        Map<String,Integer> cartMap = new HashMap<String,Integer>() ;

        discountPromotionMap.put("ITEM000001",0.9);
        secondHalfPricePromotionList.add("ITEM000001");
        offXForEachYList.add("ITEM000001");
        itemPriceMap.put("ITEM000001",40.0);
        cartMap.put("ITEM000001",10);

        promotionDocument.setDiscountPromotionMap(discountPromotionMap);
        promotionDocument.setSecondHalfPricePromotionList(secondHalfPricePromotionList);
        promotionDocument.setOffXForEachYList(offXForEachYList);
        promotionDocument.setItemPriceMap(itemPriceMap);

        HandleCartWithPromotionStrategies handleCartWithPromotionStrategies = new HandleCartWithPromotionStrategies();
        handleCartWithPromotionStrategies.setCartMap(cartMap);
        handleCartWithPromotionStrategies.setPromotionDocument(promotionDocument);

        handleCartWithPromotionStrategies.handleCart();

        assertThat(handleCartWithPromotionStrategies.itemListAfterHandling.get(0).getId(),is("ITEM000001"));
        assertThat(handleCartWithPromotionStrategies.itemListAfterHandling.get(0).getPrice(),is(26.0));

    }

}
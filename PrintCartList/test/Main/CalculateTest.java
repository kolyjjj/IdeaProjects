package Main;

import Promotions.Discount;
import Promotions.OffXForEachY;
import Promotions.Promotion;
import Promotions.SecondHalfPrice;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculateTest {

    @Test
    public void testCalculate() throws Exception {
        //Map<Item,LinkedList<Promotion>> itemsWithPromotions
        Item item = new Item("ITEM00001", 40.0);
        Discount discount = new Discount();
        discount.setDiscount(0.75);
        SecondHalfPrice secondHalfPrice = new SecondHalfPrice();
        secondHalfPrice.setNum(5);
        OffXForEachY offXForEachY = new OffXForEachY();
        offXForEachY.setNum(5);
        offXForEachY.setX(5);
        offXForEachY.setY(100);
        LinkedList<Promotion> list = new LinkedList<Promotion>();
        list.add(discount);
        list.add(secondHalfPrice);
        list.add(offXForEachY);

        Map<Item, LinkedList<Promotion>> itemsWithPromotions = new HashMap<Item, LinkedList<Promotion>>();
        itemsWithPromotions.put(item, list);
        Calculate cal = new Calculate();
        cal.calculate(itemsWithPromotions);

        assertThat(cal.itemListBeforeHandling.get(0).getId(), is(item.getId()));
        assertThat(cal.itemListBeforeHandling.get(0).getPrice(), is(item.getPrice()));

        assertThat(cal.itemListAfterHandling.get(0).getId(), is(item.getId()));
        assertThat(cal.itemListAfterHandling.get(0).getPrice(), is(23.0));
    }
}
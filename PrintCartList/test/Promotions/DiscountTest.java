package Promotions;

import Main.Item;
import MyException.MyException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class DiscountTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_get_discount_price_when_a_item_has_discount_promotions() throws MyException {

        Item item = new Item("ITEM000001", 40.0);
        Discount discount = new Discount();
        discount.setDiscount(0.5);

        discount.promotion(item);

        assertEquals(item.getPrice(), 20.0, 0.00001);
    }

    @Test
    public void should_throws_MyException_when_discount_is_smaller_than_0() throws Exception {
        Item item = new Item("ITEM000001", 40.0);
        Discount discount = new Discount();
        discount.setDiscount(-0.1);

        expectedException.expect(MyException.class);
        expectedException.expectMessage("discount can't out of the range (0,1)");

        discount.promotion(item);
    }

    @Test
    public void should_throws_MyException_when_discount_is_0() throws Exception {
        Item item = new Item("ITEM000001", 40.0);
        Discount discount = new Discount();
        discount.setDiscount(0.0);


        expectedException.expect(MyException.class);
        expectedException.expectMessage("discount can't out of the range (0,1)");

        discount.promotion(item);
    }

    @Test
    public void should_throws_MyException_when_discount_is_1() throws Exception {
        Item item = new Item("ITEM000001", 40.0);
        Discount discount = new Discount();
        discount.setDiscount(1.0);

        expectedException.expect(MyException.class);
        expectedException.expectMessage("discount can't out of the range (0,1)");

        discount.promotion(item);
    }

    @Test
    public void should_throws_MyException_when_discount_is_larger_than_1() throws Exception {
        Item item = new Item("ITEM000001", 40.0);
        Discount discount = new Discount();
        discount.setDiscount(1.1);

        expectedException.expect(MyException.class);
        expectedException.expectMessage("discount can't out of the range (0,1)");

        discount.promotion(item);
    }
}
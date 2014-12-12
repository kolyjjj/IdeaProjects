package Promotions;

import Main.Item;
import MyException.MyException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class DiscountTest {

    @Test
    public void should_get_discount_price_when_a_item_has_discount_promotions() throws Exception {

        Item item = new Item("ITEM000001",40.0);
        Discount discount = new Discount();

        discount.discount(item,0.5);

        assertEquals(item.getPrice(), 20.0, 0.00001);

    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test(expected = MyException.class)
    public void should_throws_MyException_when_discount_is_smaller_than_0() throws MyException {
        Item item = new Item("ITEM000001",40.0);
        Discount discount = new Discount();

        discount.discount(item,-0.1);

        expectedException.expect(MyException.class);
        expectedException.expectMessage("discount can't out of the range (0,1)");

    }

    @Test(expected = MyException.class)
    public void should_throws_MyException_when_discount_is_0() throws MyException {
        Item item = new Item("ITEM000001",40.0);
        Discount discount = new Discount();

        discount.discount(item,0.0);

        expectedException.expect(MyException.class);
        expectedException.expectMessage("discount can't out of the range (0,1)");

    }

    @Test(expected = MyException.class)
    public void should_throws_MyException_when_discount_is_1() throws MyException {
        Item item = new Item("ITEM000001",40.0);
        Discount discount = new Discount();

        discount.discount(item,1.0);

        expectedException.expect(MyException.class);
        expectedException.expectMessage("discount can't out of the range (0,1)");

    }

    @Test(expected = MyException.class)
    public void should_throws_MyException_when_discount_is_larger_than_1() throws MyException {
        Item item = new Item("ITEM000001",40.0);
        Discount discount = new Discount();

        discount.discount(item,1.1);

        expectedException.expect(MyException.class);
        expectedException.expectMessage("discount can't out of the range (0,1)");

    }
}
package Promotions;

import Main.Item;
import MyException.MyException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SecondHalfPriceTest {
    @Test
    public void test_second_half_price() throws Exception {
        Item item = new Item("ITEM000001",40.0);
        SecondHalfPrice secondHalfPrice = new SecondHalfPrice();

        secondHalfPrice.secondHalfPrice(item,5);

        assertThat(item.getPrice(),is((40.0+20.0+40.0+20.0+40)/5));
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test(expected = MyException.class)
    public void should_throw_MyException_when_item_quantity_is_0() throws Exception {
        Item item = new Item("ITEM000001", 40.0);
        SecondHalfPrice secondHalfPrice = new SecondHalfPrice();

        secondHalfPrice.secondHalfPrice(item, 0);

        expectedException.expect(MyException.class);
        expectedException.expectMessage("item quantity should be larger than 0");
    }

    @Test(expected = MyException.class)
    public void should_throw_MyException_when_item_quantity_is_negative() throws Exception {
        Item item = new Item("ITEM000001",40.0);
        SecondHalfPrice secondHalfPrice = new SecondHalfPrice();

        secondHalfPrice.secondHalfPrice(item,-1);

        expectedException.expect(MyException.class);
        expectedException.expectMessage("item quantity should be larger than 0");


    }
}
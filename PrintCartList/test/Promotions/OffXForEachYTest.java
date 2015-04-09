package Promotions;

import Main.Item;
import MyException.MyException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OffXForEachYTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void test_off_X_for_each_Y() throws Exception {

        Item item = new Item("ITEM000001", 40.0);
        OffXForEachY offXForEachY = new OffXForEachY();
        offXForEachY.setNum(5);
        offXForEachY.setX(5);
        offXForEachY.setY(100);

        offXForEachY.promotion(item);

        assertThat(item.getPrice(), is(190.0 / 5));
    }

    @Test
    public void should_throw_MyException_when_item_quantity_is_smaller_than_1() throws Exception {
        Item item = new Item("ITEM000001", 40.0);
        OffXForEachY offXForEachY = new OffXForEachY();
        offXForEachY.setNum(0);
        offXForEachY.setX(5);
        offXForEachY.setY(100);

        expectedException.expect(MyException.class);
        expectedException.expectMessage("item quantity can't be smaller than 1");

        offXForEachY.promotion(item);
    }

    @Test
    public void should_throw_MyException_when_X_is_0() throws Exception {
        Item item = new Item("ITEM000001", 40.0);
        OffXForEachY offXForEachY = new OffXForEachY();
        offXForEachY.setNum(5);
        offXForEachY.setX(0);
        offXForEachY.setY(100);

        expectedException.expect(MyException.class);
        expectedException.expectMessage("X can't be negative or 0.0");

        offXForEachY.promotion(item);
    }

    @Test
    public void should_throw_MyException_when_X_is_negative() throws Exception {
        Item item = new Item("ITEM000001", 40.0);
        OffXForEachY offXForEachY = new OffXForEachY();
        offXForEachY.setNum(5);
        offXForEachY.setX(-5);
        offXForEachY.setY(100);

        expectedException.expect(MyException.class);
        expectedException.expectMessage("X can't be negative or 0.0");

        offXForEachY.promotion(item);
    }

    @Test

    public void should_throw_MyException_when_Y_is_0() throws Exception {
        Item item = new Item("ITEM000001", 40.0);
        OffXForEachY offXForEachY = new OffXForEachY();
        offXForEachY.setNum(5);
        offXForEachY.setX(5);
        offXForEachY.setY(0);

        expectedException.expect(MyException.class);
        expectedException.expectMessage("Y can't be negative or 0.0");

        offXForEachY.promotion(item);
    }

    @Test
    public void should_throw_MyException_when_y_is_negative() throws Exception {
        Item item = new Item("ITEM000001", 40.0);
        OffXForEachY offXForEachY = new OffXForEachY();
        offXForEachY.setNum(5);
        offXForEachY.setX(5);
        offXForEachY.setY(-100);

        expectedException.expect(MyException.class);
        expectedException.expectMessage("Y can't be negative or 0.0");

        offXForEachY.promotion(item);
    }

    @Test
    public void should_throw_MyException_when_y_is_smaller_than_x() throws Exception {
        Item item = new Item("ITEM000001", 40.0);
        OffXForEachY offXForEachY = new OffXForEachY();
        offXForEachY.setNum(5);
        offXForEachY.setX(100);
        offXForEachY.setY(5);

        expectedException.expect(MyException.class);
        expectedException.expectMessage("Y should be larger than X");

        offXForEachY.promotion(item);
    }

    @Test
    public void should_throw_MyException_when_y_is_equal_to_x() throws Exception {
        Item item = new Item("ITEM000001", 40.0);
        OffXForEachY offXForEachY = new OffXForEachY();
        offXForEachY.setNum(5);
        offXForEachY.setX(100);
        offXForEachY.setY(100);

        expectedException.expect(MyException.class);
        expectedException.expectMessage("Y should be larger than X");

        offXForEachY.promotion(item);
    }
}
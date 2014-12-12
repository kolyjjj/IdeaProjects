package Main;

import MyException.MyException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemTest {
    @Test
    public void should_get_item_id_correctly_when_we_use_getID_method() throws Exception {
        Item item = new Item("ITEM000001",40.0);

        assertThat(item.getId(),is("ITEM000001"));


    }

    @Test
    public void should_get_item_price_correctly_when_we_use_getPrice_method() throws Exception {
        Item item = new Item("ITEM000001",40.0);

        assertThat(item.getPrice(),is(40.0));

    }

    @Test
    public void should_set_item_price_correctly_when_we_use_setPrice_method() throws Exception {
        Item item = new Item("ITEM000001",40.0);

        item.setPrice(50.0);

        assertThat(item.getPrice(), is(50.0));

    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test(expected = MyException.class)
    public void should_throws_MyException_when_price_is_smaller_than_0() throws MyException {
        Item item = new Item("ITEM000001",-40.0);

        expectedException.expect(MyException.class);
        expectedException.expectMessage("price should be larger than 0!");

    }

    @Test(expected = MyException.class)
    public void should_throws_MyException_when_price_is_0() throws MyException {
        Item item = new Item("ITEM000001",0);

        expectedException.expect(MyException.class);
        expectedException.expectMessage("price should be larger than 0!");

    }

}
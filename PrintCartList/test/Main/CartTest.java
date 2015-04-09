package Main;

import javafx.util.Pair;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CartTest {
    @Test
    public void should_tidy_cart_successfully_when_use_tidyCart_method() throws Exception {
        List<Pair<String, Integer>> cartList = new LinkedList<Pair<String, Integer>>();
        List<Pair<String, Double>> priceList = new LinkedList<Pair<String, Double>>();
        cartList.add(new Pair<String, Integer>("ITEM000001", 1));
        cartList.add(new Pair<String, Integer>("ITEM000001", 5));
        priceList.add(new Pair<String, Double>("ITEM000001", 40.0));
        Item item = new Item("ITEM000001", 40.0);

        Cart cart = new Cart();
        cart.tidyCart(cartList, priceList);
        Iterator<Item> i = cart.cartMap.keySet().iterator();
        Item j = i.next();

        assertThat(j.getId(), is(item.getId()));
        assertThat(j.getPrice(), is(item.getPrice()));
        assertThat(cart.cartMap.get(j), is(6));
    }
}
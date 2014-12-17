package Main;

import javafx.util.Pair;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CartTest {
    @Test
    public void should_tidy_cart_successfully_when_use_tidyCart_method() throws Exception {
        List<Pair<String,Integer>> cartList = new LinkedList<Pair<String, Integer>>();
        cartList.add(new Pair<String, Integer>("ITEM000001",1));
        cartList.add(new Pair<String, Integer>("ITEM000001",5));

        Cart cart = new Cart(cartList);
        cart.tidyCart();

        assertThat(cart.cartMap.get("ITEM000001"),is(6));



    }
}
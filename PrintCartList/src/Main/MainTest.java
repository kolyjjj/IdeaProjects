package Main;

import GuiceModule.MyModule;
import MyException.MyException;
import Parse.CartListParse;
import Parse.ItemPriceListParse;
import Parse.Parser;
import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.util.Pair;

import java.io.IOException;

/**
 * Created by arolla on 14-12-11.
 */
public class MainTest {

    public static void main(String[] args) throws IOException, MyException {
        Injector injector = Guice.createInjector(new MyModule());
        Parser<Pair<String, Integer>> cartBeforeTidy = injector.getInstance(CartListParse.class);// new CartListParse("cart");
        Parser<Pair<String, Double>> itemPrice = injector.getInstance(ItemPriceListParse.class);//new ItemPriceListParse("itemPriceList");

        cartBeforeTidy.parser();
        itemPrice.parser();

        Cart cartAfterTidy = new Cart();
        cartAfterTidy.tidyCart(cartBeforeTidy.list, itemPrice.list);

        PutPromotionStrategiesToItemsOfCart strategy = new PutPromotionStrategiesToItemsOfCart();
        strategy.handleCartWithPromotions(cartAfterTidy);

        Calculate cal = new Calculate();
        cal.calculate(strategy.getItemsWithPromotions());

        PrintShoppingList pr = new PrintShoppingList();
        pr.setCartMap(cartAfterTidy.cartMap);
        pr.setItemListBeforeHandling(cal.itemListBeforeHandling);
        pr.setItemListAfterHandling(cal.itemListAfterHandling);
        pr.print();
    }
}

package Main;

import MyException.MyException;
import Parse.CartListParse;
import Parse.ItemPriceListParse;
import Parse.Parser;
import javafx.util.Pair;

import java.io.IOException;

/**
 * Created by arolla on 14-12-11.
 */
public class MainTest {

    public static void main(String[] args) throws IOException, MyException {
        PromotionDocument promotionDocument = new PromotionDocument();
        promotionDocument.parsePromotionDocument("discount_promotion", "second_half_price_promotion", "off_X_for_each_Y");
        promotionDocument.listToMap();


        Parser<Pair<String,Integer>> cartBeforeTidy = new CartListParse("cart");
        cartBeforeTidy.parser(cartBeforeTidy.bufferedReader);

        Parser<Pair<String,Double>> itemPrice = new ItemPriceListParse("itemPriceList");
        itemPrice.parser(itemPrice.bufferedReader);


        Cart cartAfterTidy = new Cart();
        cartAfterTidy.tidyCart(cartBeforeTidy.list,itemPrice.list);

        PutPromotionStrategiesToItemsOfCart strategy = new PutPromotionStrategiesToItemsOfCart();
        strategy.handleCartWithPromotions(cartAfterTidy,promotionDocument);

        Calculate cal = new Calculate();
        cal.calculate(strategy.getItemsWithPromotions());

        PrintShoppingList pr = new PrintShoppingList();
        pr.setCartMap(cartAfterTidy.cartMap);
        pr.setItemListBeforeHandling(cal.itemListBeforeHandling);
        pr.setItemListAfterHandling(cal.itemListAfterHandling);
        pr.print();





    }
}

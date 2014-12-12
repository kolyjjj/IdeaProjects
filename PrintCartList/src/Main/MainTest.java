package Main;

import MyException.MyException;

import java.io.IOException;

/**
 * Created by arolla on 14-12-11.
 */
public class MainTest {

    public static void main(String[] args) throws IOException, MyException {
        ParsePromotionDocument  parsePromotionDocument = new ParsePromotionDocument("discount_promotion", "second_half_price_promotion", "off_X_for_each_Y","itemPriceList");
        parsePromotionDocument.listToMap();

        ParseAndTidyCart parseAndTidyCart = new ParseAndTidyCart("cart");
        parseAndTidyCart.tidyCart();

        HandleCartWithPromotionStrategies handleCartWithPromotionStrategies = new HandleCartWithPromotionStrategies();
        handleCartWithPromotionStrategies.setCartMap(parseAndTidyCart.cartMap);
        handleCartWithPromotionStrategies.setPromotionDocument(parsePromotionDocument);
        handleCartWithPromotionStrategies.handleCart();

        PrintShoppingList printList = new PrintShoppingList();
        printList.setCartMap(parseAndTidyCart.cartMap);
        printList.setItemListBeforeHandling(handleCartWithPromotionStrategies.itemListBeforeHandling);
        printList.setItemListAfterHandling(handleCartWithPromotionStrategies.itemListAfterHandling);
        printList.print();

    }
}

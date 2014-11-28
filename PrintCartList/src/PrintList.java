import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by arolla on 14-11-21.
 */
public class PrintList {
    public static void main(String[] args) throws IOException {
        ParseCartList parseCartList = new ParseCartList("discount_promotion","second_half_price_promotion","off_X_for_each_Y","itemPriceList",":");
        parseCartList.handleCartList("cart");
        Iterator e = parseCartList.cartListMap.entrySet().iterator();
        Discount handle_1 = new Discount();
        SecondHalfPrice handle_2 = new SecondHalfPrice();
        OffXForEachY handle_3 = new OffXForEachY();
        double totalPriceBefore = 0.0;
        double totalPriceAfter = 0.0;

        while(e.hasNext())
        {

            Map.Entry entry = (Map.Entry) e.next();
            Item item = new Item(entry.getKey().toString(),Double.parseDouble(parseCartList.itemPriceListMap.get(entry.getKey()).toString()));
            System.out.print(item.getId());
            System.out.print(" ");
            System.out.print(parseCartList.cartListMap.get(entry.getKey().toString()));
            System.out.print(" ");
            System.out.print(item.getPrice());
            System.out.print(" ");

            totalPriceBefore += item.getPrice()*parseCartList.cartListMap.get(entry.getKey().toString());

            if (parseCartList.discountPromotionMap.containsKey(item.getId()))
                item = handle_1.discount(item, Double.parseDouble(parseCartList.discountPromotionMap.get(entry.getKey()).toString()));
            if (parseCartList.secondHalfPricePromotionList.contains(item.getId()))
                item = handle_2.secondHalfPrice(item, parseCartList.cartListMap.get(entry.getKey().toString()));
            if (parseCartList.offXForEachYList.contains(item.getId()))
                item = handle_3.offXForEachY(item, parseCartList.cartListMap.get(entry.getKey().toString()), 5, 100);


            double priceTemp = item.getPrice() * parseCartList.cartListMap.get(entry.getKey().toString());
            totalPriceAfter += item.getPrice() * parseCartList.cartListMap.get(entry.getKey().toString());
            System.out.println(priceTemp);


    }
        Item item = new Item("total",totalPriceAfter);
        handle_3.offXForEachY(item, 1, 50, 300);
        System.out.print(item.getPrice());
        System.out.print(" ");
        System.out.print(totalPriceBefore);
        System.out.print(" ");
        System.out.print(item.getPrice());
        System.out.print(" ");
        System.out.print(totalPriceBefore-item.getPrice());






    }
}

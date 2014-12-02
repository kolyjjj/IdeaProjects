import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by arolla on 14-11-21.
 */
public class PrintList {
    public static void main(String[] args) throws IOException {
        //String s =null;// "/home/arolla/IdeaProjects/PrintCartList/";
        ParseTxt parseTxt = new ParseTxt("discount_promotion","second_half_price_promotion","off_X_for_each_Y","itemPriceList","cart");
        parseTxt.handleCartList();
        parseTxt.listToMap();
        //System.out.println(parseTxt.cartMap.size());

        Iterator e = parseTxt.cartMap.entrySet().iterator();
        Discount handle_1 = new Discount();
        SecondHalfPrice handle_2 = new SecondHalfPrice();
        OffXForEachY handle_3 = new OffXForEachY();
        double totalPriceBefore = 0.0;
        double totalPriceAfter = 0.0;

        while(e.hasNext())
        {

            Map.Entry entry = (Map.Entry) e.next();
         //   System.out.println(entry.getKey());
            Item item = new Item(entry.getKey().toString(), parseTxt.itemPriceMap.get(entry.getKey().toString()));
            System.out.print(item.getId());
            System.out.print(" ");
            System.out.print(parseTxt.cartMap.get(entry.getKey().toString()));
            System.out.print(" ");
            System.out.print(item.getPrice());
            System.out.print(" ");

            totalPriceBefore += item.getPrice()* parseTxt.cartMap.get(entry.getKey().toString());

            if (parseTxt.discountPromotionList.contains(item.getId()))
                item = handle_1.discount(item, parseTxt.discountPromotionMap.get(entry.getKey().toString()));
            if (parseTxt.secondHalfPricePromotionList.contains(item.getId()))
                item = handle_2.secondHalfPrice(item, parseTxt.cartMap.get(entry.getKey().toString()));
            if (parseTxt.offXForEachYList.contains(item.getId()))
                item = handle_3.offXForEachY(item, parseTxt.cartMap.get(entry.getKey().toString()), 5, 100);


            double priceTemp = item.getPrice() * parseTxt.cartMap.get(entry.getKey().toString());
            totalPriceAfter += item.getPrice() * parseTxt.cartMap.get(entry.getKey().toString());
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

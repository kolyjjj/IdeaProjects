import java.io.IOException;
import java.util.*;

/**
 * Created by arolla on 14-11-21.
 */
public class PrintList {
    public  ParseTxt parseTxt = new ParseTxt();
    public List<Item> itemInfo = new LinkedList<Item>();
    public List<Double> sumInfo = new LinkedList<Double>();

    PrintList(ParseTxt _parseTxt) throws IOException {

        parseTxt = _parseTxt;
        parseTxt.handleCartList();
        parseTxt.listToMap();

        Iterator e = parseTxt.cartMap.entrySet().iterator();
        Discount handle_1 = new Discount();
        SecondHalfPrice handle_2 = new SecondHalfPrice();
        OffXForEachY handle_3 = new OffXForEachY();
        double totalPriceBefore = 0.0;
        double totalPriceAfter = 0.0;


        while(e.hasNext())
        {

           // System.out.println(i++);//ceshi
            Map.Entry entry = (Map.Entry) e.next();
            double info = 0.0;
        //    System.out.println(entry.getKey());
            Item item = new Item(entry.getKey().toString(), parseTxt.itemPriceMap.get(entry.getKey().toString()));
            System.out.print(item.getId());
            System.out.print(" ");
            System.out.print(parseTxt.cartMap.get(entry.getKey().toString()));
            System.out.print(" ");
            System.out.print(item.getPrice());
            System.out.print(" ");
        //    info = info.concat(item.getId()).concat(" ").concat(parseTxt.cartMap.get(entry.getKey().toString()).toString()).concat(" ").concat(Double.toString(item.getPrice())).concat(" ");

            totalPriceBefore += item.getPrice()* parseTxt.cartMap.get(entry.getKey().toString());

            if (parseTxt.discountPromotionMap.containsKey(item.getId()))
                item = handle_1.discount(item, parseTxt.discountPromotionMap.get(entry.getKey().toString()));
            if (parseTxt.secondHalfPricePromotionList.contains(item.getId()))
                item = handle_2.secondHalfPrice(item, parseTxt.cartMap.get(entry.getKey().toString()));
            if (parseTxt.offXForEachYList.contains(item.getId()))
                item = handle_3.offXForEachY(item, parseTxt.cartMap.get(entry.getKey().toString()), 5, 100);


            double priceTemp = item.getPrice() * parseTxt.cartMap.get(entry.getKey().toString());
            totalPriceAfter += item.getPrice() * parseTxt.cartMap.get(entry.getKey().toString());
          //  info = info.concat(Double.toString(priceTemp));
            System.out.println(priceTemp);
            itemInfo.add(item);
            sumInfo.add(priceTemp);



    }
        Item item = new Item("total",totalPriceAfter);
        handle_3.offXForEachY(item, 1, 50, 300);
        System.out.print(item.getPrice());
        System.out.print(" ");
        System.out.print(totalPriceBefore);
        System.out.print(" ");
        System.out.print(item.getPrice());
        System.out.print(" ");
        System.out.println(totalPriceBefore-item.getPrice());






    }
}

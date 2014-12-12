package Main;

import MyException.MyException;
import Promotions.OffXForEachY;

import java.util.*;

/**
 * Created by arolla on 14-11-21.
 */
public class PrintShoppingList {

    Map<String,Integer> cartMap = new HashMap<String,Integer>() ;
    List<Item> itemListBeforeHandling = new LinkedList<Item>();
    List<Item> itemListAfterHandling= new LinkedList<Item>();
    double totalPriceBefore = 0.0;
    double totalPriceAfter =0.0;

    public void setCartMap(Map<String, Integer> cartMap) {
        this.cartMap = cartMap;
    }

    public void setItemListBeforeHandling(List<Item> itemListBeforeHandling) {
        this.itemListBeforeHandling = itemListBeforeHandling;
    }

    public void setItemListAfterHandling(List<Item> itemListAfterHandling) {
        this.itemListAfterHandling = itemListAfterHandling;
    }

    public void print() throws MyException {
        System.out.println("购物明细   （数量 单价 小计）");

        for (int i = 0; i < cartMap.size(); i++){
            String itemName = itemListBeforeHandling.get(i).getId();
            int itemQuantity = cartMap.get(itemName);
            double itemPriceBefore = itemListBeforeHandling.get(i).getPrice();
            double itemPriceAfter = itemListAfterHandling.get(i).getPrice();

            System.out.print(itemName);
            System.out.print("  ");
            System.out.print(itemQuantity);
            System.out.print("  ");
            System.out.print(itemPriceBefore);
            System.out.print("  ");
            System.out.println(itemQuantity * itemPriceAfter);

            totalPriceBefore += itemPriceBefore*itemQuantity;
            totalPriceAfter += itemPriceAfter*itemQuantity;
        }

        Item abstractTotalItem = new Item("total", totalPriceAfter);
        abstractTotalItem = new OffXForEachY().offXForEachY(abstractTotalItem,1,3,100);

        System.out.println("总计金额（优惠前 优惠后 优惠差价）");
        System.out.print(abstractTotalItem.getPrice());
        System.out.print("   ");
        System.out.print(totalPriceBefore);
        System.out.print("  ");
        System.out.print(abstractTotalItem.getPrice());
        System.out.print("  ");
        System.out.println(totalPriceBefore-abstractTotalItem.getPrice());



    }



    }


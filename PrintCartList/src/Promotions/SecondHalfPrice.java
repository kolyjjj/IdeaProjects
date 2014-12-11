package Promotions;

import Main.Item;

/**
 * Created by arolla on 14-11-28.
 */
public class SecondHalfPrice  {

    public Item secondHalfPrice(Item item, int num){

        double price = item.getPrice();
        price = (price*num - price*0.5*(num/2))/num;

        item.setPrice(price);
        return item;

    }
}

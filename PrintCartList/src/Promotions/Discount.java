package Promotions;

import Main.Item;

/**
 * Created by arolla on 14-11-28.
 */
 public class Discount {

    public Item discount(Item item, double discount){

        item.setPrice(item.getPrice()*discount);
        return item;
    }


}

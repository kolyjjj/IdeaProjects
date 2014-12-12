package Promotions;

import Main.Item;
import MyException.MyException;

/**
 * Created by arolla on 14-11-28.
 */
 public class Discount {

    public Item discount(Item item, double discount) throws MyException{

        if (discount<=0.0||discount>=1.0)
           throw new MyException("discount can't out of the range (0,1)");
        item.setPrice(item.getPrice()*discount);
        return item;
    }


}

package Promotions;

import Main.Item;
import MyException.MyException;

/**
 * Created by arolla on 14-11-28.
 */
public class SecondHalfPrice  {

    public Item secondHalfPrice(Item item, int num) throws MyException{

        if (num <= 0) {
            throw new MyException("item quantity should be larger than 0");
        }

        double price = item.getPrice();
        price = (price*num - price*0.5*(num/2))/num;

        item.setPrice(price);
        return item;

    }
}

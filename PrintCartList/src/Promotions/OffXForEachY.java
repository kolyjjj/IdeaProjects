package Promotions;

import Main.Item;
import MyException.MyException;

/**
 * Created by arolla on 14-11-28.
 */
public class OffXForEachY {

    public Item offXForEachY(Item item, int num, int x, int y)throws MyException{

        if (num < 1)
            throw new MyException("item quantity can't be smaller than 1");
        if (x<=0.0)
            throw new MyException("X can't be negative or 0.0");
        if (y<=0.0)
            throw new MyException("Y can't be negative or 0.0");
        if (x>=y)
            throw new MyException("Y should be larger than X");

        double price = item.getPrice();
        int n = (int)(price*num/y);
        price = (price*num - x*n)/num;

        item.setPrice(price);
        return item;

    }
}

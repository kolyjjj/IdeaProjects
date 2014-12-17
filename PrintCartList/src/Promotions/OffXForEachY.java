package Promotions;

import Main.Item;
import MyException.MyException;

/**
 * Created by arolla on 14-11-28.
 */
public class OffXForEachY implements Promotion {

    int num;
    int x = 0;
    int y = 0;

    public void setNum(int num) {
        this.num = num;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

//    public Item offXForEachY(Item item, int num, int x, int y)throws MyException{
//
//        if (num < 1)
//            throw new MyException("item quantity can't be smaller than 1");
//        if (x<=0.0)
//            throw new MyException("X can't be negative or 0.0");
//        if (y<=0.0)
//            throw new MyException("Y can't be negative or 0.0");
//        if (x>=y)
//            throw new MyException("Y should be larger than X");
//
//        double price = item.getPrice();
//        int n = (int)(price*num/y);
//        price = (price*num - x*n)/num;
//
//        item.setPrice(price);
//        return item;
//
//    }

    @Override
    public Item promotion(Item item) throws MyException{

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

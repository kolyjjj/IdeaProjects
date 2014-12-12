package Main;

import MyException.MyException;

/**
 * Created by arolla on 14-11-21.
 */
public class Item
{
    private String id = new String();
    private double price = 0.0;

 public Item(String _id, double _price)throws MyException
    {
        if (_price<= 0)
            throw new MyException("price should be larger than 0!");
        id = _id;
        price = _price;


    }
    public String getId(){
        return  id;
    }
    public  double getPrice(){
        return  price;
    }

    public void setPrice(double _price) {
        price = _price;

    }




}

/**
 * Created by arolla on 14-11-21.
 */
public class Item
{
    private String id = new String();
    private double price = 0.0;
    private double discount = 1.0;
    private Boolean isHasSecondHalfPricePromotion = false;
    private int count = 0;
//构造函数
    Item(String _id, double _price)
    {
        id = _id;
        price = _price;

    }
//方法 返回价格，折扣。设置打折，第二件商品半价，商品数量
    public String getId(){
        return  id;
    }

    public  double getPrice(){
        return  price;
    }
    public void setDiscount(double _discount)
    {
        discount = _discount;
    }

    public void setIsHasSecondHalfPricePromotion(Boolean _isHasSecondHalfPricePromotion)
    {
        isHasSecondHalfPricePromotion = _isHasSecondHalfPricePromotion;
    }

    public void setCount(int _count)
    {
        count = _count;
    }

    public double getPriceWithoutPromotions()
    {
        return price * count;
    }

    public double getPriceWithPromotions()
    {
        if ( count == 1)
        {
            return price * discount;
        }

        else
        {
            if (isHasSecondHalfPricePromotion)
            {
                return price * discount * (1 + 0.5) * ((int)(count / 2)) + price * discount * (count - 2*((int)(count / 2)));

            }
            else
            {
                return price * discount * count;
            }
        }

    }

    public void printData()
    {
        System.out.println(id+' '+count+' '+price+' '+getPriceWithPromotions());
    }

}

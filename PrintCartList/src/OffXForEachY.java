/**
 * Created by arolla on 14-11-28.
 */
public class OffXForEachY {
    Item offXForEachY(Item item, int num, int x, int y){

        double price = item.getPrice();
        int n = (int)price*num/y;
        price = (price*num - x*n)/num;

        item.setPrice(price);
        return item;

    }
}

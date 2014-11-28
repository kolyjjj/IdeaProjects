/**
 * Created by arolla on 14-11-28.
 */
 public class Discount {
    Item discount(Item item, double discount){

        item.setPrice(item.getPrice()*discount);
        return item;
    }


}

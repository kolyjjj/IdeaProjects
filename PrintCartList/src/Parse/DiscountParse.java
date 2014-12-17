package Parse;

import Promotions.Discount;
import javafx.util.Pair;

import java.io.FileNotFoundException;

/**
 * Created by arolla on 14-12-1.
 */
public class DiscountParse extends Parser<Pair<String,Discount>> {

    public DiscountParse(String _path) throws FileNotFoundException {
        super(_path);
    }

    public DiscountParse() {

    }

    @Override
    public Pair<String, Discount> convert(String line){
        String[] tokens = line.split(":");
        String itemId = tokens[0];
        Discount promotion = new Discount();
        promotion.setDiscount(Double.parseDouble(tokens[1]));
        return new Pair<String, Discount>(itemId,promotion);
    }


}

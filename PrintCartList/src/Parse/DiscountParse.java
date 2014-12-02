package Parse;

import Parse.Parser;
import javafx.util.Pair;

/**
 * Created by arolla on 14-12-1.
 */
public class DiscountParse extends Parser<Pair<String,Double>> {

    @Override
    protected Pair<String,Double> convert (String line){
        String[] tokens = line.split(":");
        return new Pair<String, Double>(tokens[0],Double.parseDouble(tokens[1]));
    }


}

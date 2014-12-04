package Parse;

import javafx.util.Pair;

/**
 * Created by arolla on 14-12-1.
 */
public class ItemPriceListParse extends Parser<Pair<String,Double>>{


    @Override
    public Pair<String,Double> convert(String line){
        String tokens[] = line.split(":");
        return new Pair<String, Double>(tokens[0],Double.parseDouble(tokens[1]));

    }
}

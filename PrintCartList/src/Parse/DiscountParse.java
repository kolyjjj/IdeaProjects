package Parse;

import javafx.util.Pair;

import java.io.FileNotFoundException;

/**
 * Created by arolla on 14-12-1.
 */
public class DiscountParse extends Parser<Pair<String,Double>> {

    public DiscountParse(String _path) throws FileNotFoundException {
        super(_path);
    }

    public DiscountParse() {

    }

    @Override
    public Pair<String,Double> convert (String line){
        String[] tokens = line.split(":");
        return new Pair<String, Double>(tokens[0],Double.parseDouble(tokens[1]));
    }


}

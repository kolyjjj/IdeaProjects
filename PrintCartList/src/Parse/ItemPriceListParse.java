package Parse;

import javafx.util.Pair;

import java.io.FileNotFoundException;

/**
 * Created by.
 */
public class ItemPriceListParse extends Parser<Pair<String,Double>>{


    public ItemPriceListParse(String _path) throws FileNotFoundException {
        super(_path);
    }

    public ItemPriceListParse() {

    }

    @Override
    public Pair<String,Double> convert(String line){
        String tokens[] = line.split(":");
        return new Pair<String,Double>(tokens[0],Double.parseDouble(tokens[1]));

    }
}

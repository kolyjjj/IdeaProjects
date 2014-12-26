package Parse;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import javafx.util.Pair;

import java.io.FileNotFoundException;

/**
 * Created by.
 */
public class ItemPriceListParse extends Parser<Pair<String,Double>>{

@Inject
    public ItemPriceListParse(@Named("ItemPriceList txt Name")String _path) throws FileNotFoundException {
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

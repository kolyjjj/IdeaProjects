package Parse;

import Promotions.SecondHalfPrice;
import javafx.util.Pair;

import java.io.FileNotFoundException;

/**
 * Created by arolla on 14-12-1.
 */
public class SecondHalfPriceParse extends Parser<Pair<String, SecondHalfPrice>> {

    public SecondHalfPriceParse(String _path) throws FileNotFoundException {
        super(_path);
    }

    public SecondHalfPriceParse() {

    }

    @Override
    public Pair<String, SecondHalfPrice> convert(String line) {
        return new Pair<String, SecondHalfPrice>(line,new SecondHalfPrice());
    }
}

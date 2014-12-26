package Parse;

import Promotions.SecondHalfPrice;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import javafx.util.Pair;

import java.io.FileNotFoundException;

/**
 * Created by arolla on 14-12-1.
 */
public class SecondHalfPriceParse extends Parser<Pair<String, SecondHalfPrice>> {

@Inject
    public SecondHalfPriceParse(@Named("SecondHalfPrice txt Name")String _path) throws FileNotFoundException {
        super(_path);
    }

    public SecondHalfPriceParse() {

    }

    @Override
    public Pair<String, SecondHalfPrice> convert(String line) {
        return new Pair<String, SecondHalfPrice>(line,new SecondHalfPrice());
    }
}

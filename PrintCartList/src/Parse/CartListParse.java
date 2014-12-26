package Parse;

//import javafx.util.Pair;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import javafx.util.Pair;

import java.io.FileNotFoundException;

/**
 * Created by arolla on 14-12-2.
 */
public class CartListParse extends Parser<Pair<String,Integer>> {

@Inject
    public CartListParse(@Named("Cart txt Name")String _path) throws FileNotFoundException {
        super(_path);
    }

    public CartListParse() {

    }


    @Override
    public Pair<String,Integer>convert(String line) {

        if (line.length()>10) {
            String[] tokens = line.split("-");

            return new Pair<String, Integer>(tokens[0], Integer.parseInt(tokens[1]));

        } else return new Pair<String, Integer>(line, 1);



    }
}

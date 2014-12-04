package Parse;

import javafx.util.Pair;

/**
 * Created by arolla on 14-12-2.
 */
public class CartListParse extends Parser<Pair<String,Integer>> {

    @Override
    public Pair<String, Integer> convert(String line) {
        if (line.length()>10) {
            String[] tokens = line.split("-");

            return new Pair<String, Integer>(tokens[0], Integer.parseInt(tokens[1]));

        } else return new Pair<String, Integer>(line, 1);


    }
}

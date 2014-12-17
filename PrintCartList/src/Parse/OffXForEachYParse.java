package Parse;

import Promotions.OffXForEachY;
import javafx.util.Pair;

import java.io.FileNotFoundException;

/**
 * Created by arolla on 14-12-1.
 */
public class OffXForEachYParse extends Parser<Pair<String,OffXForEachY> >  {

    public OffXForEachYParse(String _path) throws FileNotFoundException {
        super(_path);
    }

    public OffXForEachYParse() {

    }

    @Override
    public Pair<String, OffXForEachY> convert(String line){
        String itemId = line;
        OffXForEachY promotion = new OffXForEachY();
        promotion.setX(5);
        promotion.setY(100);
        return new Pair<String, OffXForEachY>(itemId,promotion);
    }
}

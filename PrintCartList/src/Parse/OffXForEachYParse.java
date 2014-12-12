package Parse;

import java.io.FileNotFoundException;

/**
 * Created by arolla on 14-12-1.
 */
public class OffXForEachYParse extends Parser<String> {

    public OffXForEachYParse(String _path) throws FileNotFoundException {
        super(_path);
    }

    public OffXForEachYParse() {

    }

    @Override
    public String convert(String line){
        return line;
    }
}

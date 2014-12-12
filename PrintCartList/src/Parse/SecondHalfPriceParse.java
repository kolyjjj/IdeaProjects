package Parse;

import java.io.FileNotFoundException;

/**
 * Created by arolla on 14-12-1.
 */
public class SecondHalfPriceParse extends Parser<String> {

    public SecondHalfPriceParse(String _path) throws FileNotFoundException {
        super(_path);
    }

    public SecondHalfPriceParse() {

    }

    @Override
    public String convert(String line)
    {
        return line;
    }
}

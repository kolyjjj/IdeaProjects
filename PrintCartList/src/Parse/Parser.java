package Parse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.lang.*;

/**
 * Created by arolla on 14-12-1.
 */
public abstract class Parser<T> {

    public List<T> parser(String _path) throws IOException{
        List<T> list = new LinkedList<T>();
      //  Path path = Paths.get(_path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(_path));
        String line = null;
        while( (line=bufferedReader.readLine()) != null){
            list.add(convert(line) );
        }
        return  list;

    }

    protected abstract T convert (String line);

}



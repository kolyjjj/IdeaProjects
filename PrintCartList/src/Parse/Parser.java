package Parse;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by arolla on 14-12-1.
 */
public abstract class Parser<T> {
    public List<T> list = new LinkedList<T>();

    public BufferedReader bufferedReader;
    Parser(){}

    Parser(String _path) throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader(new File("/home/arolla/IdeaProjects/PrintCartList",_path)));

    }

    public List<T> parser(BufferedReader bufferedReader) throws IOException{

        String line ;
        while((line=bufferedReader.readLine()) != null&& !line.isEmpty()){
            list.add(convert(line) );
        }
        return  list;
     }


     public abstract T convert(String line);

}



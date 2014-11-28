import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by arolla on 14-11-23.
 */
public interface Parse{
    public List<String> parse(String path) throws IOException;
    public Map<Object,Object> parse(String path,String delimiter) throws IOException;



}

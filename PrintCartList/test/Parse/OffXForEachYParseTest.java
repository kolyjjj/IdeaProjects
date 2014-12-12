package Parse;

import org.junit.Test;

import java.io.BufferedReader;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OffXForEachYParseTest {
    @Test
    public void test_off_x_for_each_y_parse() throws Exception {
        OffXForEachYParse offXForEachY = new OffXForEachYParse();
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("ITEM000001").thenReturn(null);

        List<String> list = offXForEachY.parser(reader);

        assertThat(list.get(0),is("ITEM000001"));

    }
}
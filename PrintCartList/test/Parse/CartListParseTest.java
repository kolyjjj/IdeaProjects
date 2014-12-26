package Parse;

import javafx.util.Pair;
import org.junit.Test;

import java.io.BufferedReader;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CartListParseTest {
    @Test
    public void test_cartList_parse_when_quantity_is_1() throws Exception {

        CartListParse cartListParse = new CartListParse();
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("ITEM000001").thenReturn(null);
        cartListParse.bufferedReader = reader;

        List<Pair<String,Integer>> list = cartListParse.parser();

        assertThat(list.get(0).getKey(),is("ITEM000001"));
        assertThat(list.get(0).getValue(), is(1));

    }

    @Test
    public void test_cartList_parse_when_quantity_is_larger_than_1() throws Exception {

        CartListParse cartListParse = new CartListParse();
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("ITEM000001-4").thenReturn(null);
        cartListParse.bufferedReader = reader;

        List<Pair<String,Integer>> list = cartListParse.parser();

        assertThat(list.get(0).getKey(),is("ITEM000001"));
        assertThat(list.get(0).getValue(),is(4));

    }
}
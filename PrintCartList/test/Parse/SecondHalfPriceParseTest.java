package Parse;

import Promotions.SecondHalfPrice;
import javafx.util.Pair;
import org.junit.Test;

import java.io.BufferedReader;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SecondHalfPriceParseTest {
    @Test
    public void test_second_half_price_parse() throws Exception {
        SecondHalfPriceParse secondHalfPriceParse = new SecondHalfPriceParse();
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("ITEM000001").thenReturn(null);
        secondHalfPriceParse.bufferedReader = reader;

        List<Pair<String, SecondHalfPrice>> list = secondHalfPriceParse.parser();

        assertThat(list.get(0).getKey(),is("ITEM000001"));
        assertThat(list.get(0).getValue(),is(SecondHalfPrice.class));


    }
}
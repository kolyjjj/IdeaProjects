package Parse;

import javafx.util.Pair;
import org.junit.Test;

import java.io.BufferedReader;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemPriceListParseTest {
    @Test
    public void test_item_price_list_parse() throws Exception {

            ItemPriceListParse itemPriceListParse = new ItemPriceListParse();
            BufferedReader reader = mock(BufferedReader.class);
            when(reader.readLine()).thenReturn("ITEM00001:40").thenReturn(null);

            List<Pair<String,Double>> list = itemPriceListParse.parser(reader);

            assertThat(list.get(0).getKey(), is("ITEM00001"));
            assertThat(list.get(0).getValue(),is(40.0));

        }



}
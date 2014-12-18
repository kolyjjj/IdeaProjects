package Parse;

import Promotions.Discount;
import javafx.util.Pair;
import org.junit.Test;

import java.io.BufferedReader;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DiscountParseTest {
     @Test
      public void test_discount_parse_() throws Exception {

        DiscountParse discountParse = new DiscountParse();
        BufferedReader reader = mock(BufferedReader.class);
         when(reader.readLine()).thenReturn("ITEM00001:0.75").thenReturn(null);

        List<Pair<String, Discount>> list = discountParse.parser(reader);

        assertThat(list.get(0).getKey(), is("ITEM00001"));
        assertThat(list.get(0).getValue().getDiscount(),is(0.75));

    }

}
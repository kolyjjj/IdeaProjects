import Parse.*;
import javafx.util.Pair;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void test_discount_parse_() throws Exception {
        Parser<Pair<String,Double>> parser = new DiscountParse();

        Pair<String,Double> pair = parser.convert("ITEM00001:0.75");

        assertThat(pair.getKey(),is("ITEM00001"));
        assertThat(pair.getValue(),is(0.75));

    }

    @Test
    public void test_second_half_price_parse() throws Exception {
        Parser<String> parser = new SecondHalfPriceParse();

        String string = parser.convert("ITEM00001");

        assertThat(string,is("ITEM00001"));

    }

    @Test
    public void test_item_price_list_parse() throws Exception {
        Parser<Pair<String,Double>> parser = new ItemPriceListParse();

        Pair<String,Double> pair = parser.convert("ITEM00001:40");

        assertThat(pair.getKey(),is("ITEM00001"));
        assertThat(pair.getValue(),is(40.0));

    }

    @Test
    public void test_off_x_for_each_y_parse() throws Exception {

        Parser<String> parser = new OffXForEachYParse();

        String string = parser.convert("ITEM00001");

        assertThat(string,is("ITEM00001"));

    }

    @Test
    public void test_cart_list_parse() throws Exception {
        Parser<Pair<String,Integer>> parser = new CartListParse();

        Pair<String,Integer> pair1 = parser.convert("ITEM00001-3");
        Pair<String,Integer> pair2 = parser.convert("ITEM00003");

        assertThat(pair1.getKey(),is("ITEM00001"));
        assertThat(pair1.getValue(),is(3));
        assertThat(pair2.getKey(),is("ITEM00003"));
        assertThat(pair2.getValue(),is(1));


    }
}
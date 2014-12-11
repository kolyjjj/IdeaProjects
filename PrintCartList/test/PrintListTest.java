//import Main.PrintList;
//import javafx.util.Pair;
//import org.junit.Test;
//
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.assertThat;
//import static org.junit.Assert.assertTrue;
//
///**
// * Created by arolla on 14-12-3.
// */
//public class PrintListTest {
//    @Test
//    public void should_get_original_sum_when_given_the_item_without_promotions() throws Exception {
//        ParseTxt parseTxt = new ParseTxt();
//
//        parseTxt.itemPriceList.add( new Pair<String, Double>("ITEM00005",60.0));
//        parseTxt.cartList.add(new Pair<String, Integer>("ITEM00005",1));
//
//       // parseTxt.listToMap();//PrintListWillDoIT!
//      //  parseTxt.handleCartList();//PrintListWillDoIT!
//
//        PrintList printList = new PrintList(parseTxt);
//
//
//
//        assertThat(printList.itemInfo.get(0).getId(), is("ITEM00005"));
//        assertThat(printList.itemInfo.get(0).getPrice(), is(60.0));
//        assertThat(printList.sumInfo.get(0),is(60.0));
//
//
//    }
//
//    @Test
//    public void should_get_discount_sum_when_given_the_item_with_discount_promotion () throws Exception {
//        ParseTxt parseTxt = new ParseTxt();
//        parseTxt.itemPriceList.add( new Pair<String, Double>("ITEM00001",40.0));
//        parseTxt.cartList.add(new Pair<String, Integer>("ITEM00001",5));
//        parseTxt.discountPromotionList.add(new Pair<String, Double>("ITEM00001",0.75));
//
//
//        PrintList printList = new PrintList(parseTxt);
//
//        assertThat(printList.itemInfo.get(0).getId(), is("ITEM00001"));
//        assertThat(printList.itemInfo.get(0).getPrice(), is(40.0*0.75));
//        assertThat(printList.sumInfo.get(0),is(40.0*0.75*5));
//
//
//    }
//
//    @Test
//    public void should_get_second_half_price_sum_when_given_the_item_with_second_half_price_promotion() throws Exception {
//        ParseTxt parseTxt = new ParseTxt();
//        parseTxt.itemPriceList.add( new Pair<String, Double>("ITEM00001",40.0));
//        parseTxt.cartList.add(new Pair<String, Integer>("ITEM00001",5));
//        parseTxt.secondHalfPricePromotionList.add(new String("ITEM00001"));
//
//
//        PrintList printList = new PrintList(parseTxt);
//
//        assertThat(printList.itemInfo.get(0).getId(), is("ITEM00001"));
//        assertThat(printList.itemInfo.get(0).getPrice(), is((40.0+20.0+40.0+20.0+40.0)/5));
//        assertThat(printList.sumInfo.get(0),is(40.0+20.0+40.0+20.0+40.0));
//
//    }
//
//    @Test
//    public void should_off_5_for_each_100_when_given_the_item_with_off_x_for_each_y_promotion() throws Exception {
//        ParseTxt parseTxt = new ParseTxt();
//        parseTxt.itemPriceList.add( new Pair<String, Double>("ITEM00001",40.0));
//        parseTxt.cartList.add(new Pair<String, Integer>("ITEM00001",5));
//        parseTxt.offXForEachYList.add(new String("ITEM00001"));
//
//
//        PrintList printList = new PrintList(parseTxt);
//
//        assertThat(printList.itemInfo.get(0).getId(), is("ITEM00001"));
//        int n = (int)(40.0*5/100);
//        assertThat(printList.itemInfo.get(0).getPrice(), is((40.0*5-n*5)/5));
//        assertThat(printList.sumInfo.get(0),is(40.0*5-n*5));
//
//
//
//    }
//}

package Main;

import Parse.*;
import javafx.util.Pair;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by arolla on 14-12-11.
 */
public class ParsePromotionDocument {
    List<Pair<String,Double>> discountPromotionList;
    Map<String,Double> discountPromotionMap = new HashMap<String, Double>();
    List<String> secondHalfPricePromotionList;
    List<String> offXForEachYList;
    List<Pair<String,Double>> itemPriceList;
    Map<String,Double> itemPriceMap = new HashMap<String, Double>();



    ParsePromotionDocument()
    {
        discountPromotionList = new LinkedList<Pair<String, Double>>();
        secondHalfPricePromotionList = new LinkedList<String>();
        offXForEachYList = new LinkedList<String>();
        itemPriceList = new LinkedList<Pair<String, Double>>();

        discountPromotionMap = new HashMap<String, Double>();
        itemPriceMap = new HashMap<String, Double>();


    }

    ParsePromotionDocument(String _discountPromotionPath, String _secondHalfPricePromotionPath, String _offXForEachYPath, String _itemPriceListPath) throws IOException {
        discountPromotionList = new DiscountParse().parser(_discountPromotionPath);//("discount_promotion", ":");
        secondHalfPricePromotionList= new SecondHalfPriceParse().parser(_secondHalfPricePromotionPath);//("second_half_price_promotion");
        offXForEachYList= new OffXForEachYParse().parser(_offXForEachYPath);//("off_X_for_each_Y");
        itemPriceList = new ItemPriceListParse().parser(_itemPriceListPath);/* ("itemPriceList", ":"); */

    }

    public void listToMap(){
        if (!discountPromotionList.isEmpty()) {
            for (Pair<String, Double> lines : discountPromotionList) {
                discountPromotionMap.put(lines.getKey(), lines.getValue());
            }
        }
        if (!itemPriceList.isEmpty()){
            for (Pair<String,Double> lines:itemPriceList){
                itemPriceMap.put(lines.getKey(),lines.getValue());
            }
        }

    }
}

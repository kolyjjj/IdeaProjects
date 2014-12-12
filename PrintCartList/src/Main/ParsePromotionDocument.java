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

    public void setDiscountPromotionMap(Map<String, Double> discountPromotionMap) {
        this.discountPromotionMap = discountPromotionMap;
    }

    public void setSecondHalfPricePromotionList(List<String> secondHalfPricePromotionList) {
        this.secondHalfPricePromotionList = secondHalfPricePromotionList;
    }

    public void setOffXForEachYList(List offXForEachYList) {
        this.offXForEachYList = offXForEachYList;
    }

    public void setItemPriceMap(Map<String, Double> itemPriceMap) {
        this.itemPriceMap = itemPriceMap;
    }


    ParsePromotionDocument(String _discountPromotionPath, String _secondHalfPricePromotionPath, String _offXForEachYPath, String _itemPriceListPath) throws IOException {
        Parser discountParse = new DiscountParse(_discountPromotionPath);
        discountPromotionList = discountParse.parser(discountParse.bufferedReader);//("discount_promotion", ":");

        Parser secondHalfPriceParse = new SecondHalfPriceParse(_secondHalfPricePromotionPath);
        secondHalfPricePromotionList= secondHalfPriceParse.parser(secondHalfPriceParse.bufferedReader);//("second_half_price_promotion");

        Parser offXForEachYParse = new OffXForEachYParse(_offXForEachYPath);
        offXForEachYList= offXForEachYParse.parser(offXForEachYParse.bufferedReader);//("off_X_for_each_Y");

        Parser itemPriceListParse =  new ItemPriceListParse(_itemPriceListPath);
        itemPriceList =itemPriceListParse.parser(itemPriceListParse.bufferedReader);/* ("itemPriceList", ":"); */

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

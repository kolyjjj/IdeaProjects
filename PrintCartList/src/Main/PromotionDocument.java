package Main;

import Parse.DiscountParse;
import Parse.OffXForEachYParse;
import Parse.Parser;
import Parse.SecondHalfPriceParse;
import Promotions.Discount;
import Promotions.OffXForEachY;
import Promotions.SecondHalfPrice;
import javafx.util.Pair;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by arolla on 14-12-11.
 */
public class PromotionDocument {


    List<Pair<String,Discount>> discountPromotionList = new LinkedList<Pair<String, Discount>>();
    //Map<String,Double> discountPromotionMap = new HashMap<String, Double>();
    List<Pair<String, SecondHalfPrice>> secondHalfPricePromotionList = new LinkedList<Pair<String, SecondHalfPrice>>();
    List<Pair<String,OffXForEachY>> offXForEachYList = new LinkedList<Pair<String, OffXForEachY>>();
   // List<Pair<String,Double>> itemPriceList;
   // Map<String,Double> itemPriceMap = new HashMap<String, Double>();

    Map<String,Discount> discountPromotionMap = new HashMap<String, Discount>();
    Map<String,SecondHalfPrice> secondHalfPricePromotionMap = new HashMap<String, SecondHalfPrice>();
    Map<String,OffXForEachY> offXForEachYListMap = new HashMap<String, OffXForEachY>();



    PromotionDocument()
    {
//        discountPromotionList = new LinkedList<Pair<String, Discount>>();
//        secondHalfPricePromotionList = new LinkedList<Pair<String, SecondHalfPrice>>();
//        offXForEachYList = new LinkedList<Pair<String, OffXForEachY>>();

//        itemPriceList = new LinkedList<Pair<String, Double>>();
//
//        discountPromotionMap = new HashMap<String, Double>();
//        itemPriceMap = new HashMap<String, Double>();


    }

    public void setDiscountPromotionList (List<Pair<String,Discount>> discountPromotionList) {
        this.discountPromotionList = discountPromotionList;
    }

    public void setSecondHalfPricePromotionList(List<Pair<String, SecondHalfPrice>> secondHalfPricePromotionList) {
        this.secondHalfPricePromotionList = secondHalfPricePromotionList;
    }

    public void setOffXForEachYList(List<Pair<String,OffXForEachY>>  offXForEachYList) {
        this.offXForEachYList = offXForEachYList;
    }

//    public void setItemPriceMap(Map<String, Double> itemPriceMap) {
//        this.itemPriceMap = itemPriceMap;
//    }


    public void parsePromotionDocument(String _discountPromotionPath, String _secondHalfPricePromotionPath, String _offXForEachYPath/*, String _itemPriceListPath*/) throws IOException {
        Parser<Pair<String, Discount>> discountParse = new DiscountParse(_discountPromotionPath);
        discountPromotionList = discountParse.parser(discountParse.bufferedReader);//("discount_promotion", ":");

        Parser<Pair<String, SecondHalfPrice>> secondHalfPriceParse = new SecondHalfPriceParse(_secondHalfPricePromotionPath);
        secondHalfPricePromotionList= secondHalfPriceParse.parser(secondHalfPriceParse.bufferedReader);//("second_half_price_promotion");

        Parser<Pair<String, OffXForEachY> >  offXForEachYParse = new OffXForEachYParse(_offXForEachYPath);
        offXForEachYList= offXForEachYParse.parser(offXForEachYParse.bufferedReader);//("off_X_for_each_Y");

//        Parser itemPriceListParse =  new ItemPriceListParse(_itemPriceListPath);
//        itemPriceList =itemPriceListParse.parser(itemPriceListParse.bufferedReader);/* ("itemPriceList", ":"); */

    }

    public void listToMap(){
        if (!discountPromotionList.isEmpty()) {
            for (Pair<String, Discount> lines : discountPromotionList) {
                if (lines == null)break;
                discountPromotionMap.put(lines.getKey(), lines.getValue());
            }
        }
        if (!secondHalfPricePromotionList.isEmpty()) {
            for (Pair<String, SecondHalfPrice> lines : secondHalfPricePromotionList) {
                if (lines == null)break;
                secondHalfPricePromotionMap.put(lines.getKey(), lines.getValue());
            }
        }
        if (!offXForEachYList.isEmpty()) {
            for (Pair<String, OffXForEachY> lines : offXForEachYList) {
                if (lines == null)break;
                offXForEachYListMap.put(lines.getKey(), lines.getValue());
            }
        }
      //  System.out.println(secondHalfPricePromotionList.size());//ceshi

    }
   // public boolean hasPromotion(String itemId,String )
}

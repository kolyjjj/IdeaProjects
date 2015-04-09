package Main;

import GuiceModule.MyModule;
import Parse.DiscountParse;
import Parse.OffXForEachYParse;
import Parse.SecondHalfPriceParse;
import Promotions.Discount;
import Promotions.OffXForEachY;
import Promotions.SecondHalfPrice;
import com.google.inject.Guice;
import com.google.inject.Injector;
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
    Injector injector = Guice.createInjector(new MyModule());
    DiscountParse parse1 = injector.getInstance(DiscountParse.class);
    SecondHalfPriceParse parse2 = injector.getInstance(SecondHalfPriceParse.class);
    OffXForEachYParse parse3 = injector.getInstance(OffXForEachYParse.class);

    List<Pair<String, Discount>> discountPromotionList = new LinkedList<Pair<String, Discount>>();
    List<Pair<String, SecondHalfPrice>> secondHalfPricePromotionList = new LinkedList<Pair<String, SecondHalfPrice>>();
    List<Pair<String, OffXForEachY>> offXForEachYList = new LinkedList<Pair<String, OffXForEachY>>();

    Map<String, Discount> discountPromotionMap = new HashMap<String, Discount>();
    Map<String, SecondHalfPrice> secondHalfPricePromotionMap = new HashMap<String, SecondHalfPrice>();
    Map<String, OffXForEachY> offXForEachYListMap = new HashMap<String, OffXForEachY>();

    public void setDiscountPromotionList(List<Pair<String, Discount>> discountPromotionList) {
        this.discountPromotionList = discountPromotionList;
    }

    public void setSecondHalfPricePromotionList(List<Pair<String, SecondHalfPrice>> secondHalfPricePromotionList) {
        this.secondHalfPricePromotionList = secondHalfPricePromotionList;
    }

    public void setOffXForEachYList(List<Pair<String, OffXForEachY>> offXForEachYList) {
        this.offXForEachYList = offXForEachYList;
    }

    public void parsePromotionDocument() throws IOException {

        discountPromotionList = parse1.parser();

        secondHalfPricePromotionList = parse2.parser();

        offXForEachYList = parse3.parser();

    }

    public void listToMap() {
        if (!discountPromotionList.isEmpty()) {
            for (Pair<String, Discount> lines : discountPromotionList) {
                if (lines == null) break;
                discountPromotionMap.put(lines.getKey(), lines.getValue());
            }
        }
        if (!secondHalfPricePromotionList.isEmpty()) {
            for (Pair<String, SecondHalfPrice> lines : secondHalfPricePromotionList) {
                if (lines == null) break;
                secondHalfPricePromotionMap.put(lines.getKey(), lines.getValue());
            }
        }
        if (!offXForEachYList.isEmpty()) {
            for (Pair<String, OffXForEachY> lines : offXForEachYList) {
                if (lines == null) break;
                offXForEachYListMap.put(lines.getKey(), lines.getValue());
            }
        }
    }
}

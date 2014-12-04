import Parse.*;
import javafx.util.Pair;

import java.io.*;
import java.util.HashMap;
import java.util.*;
import java.lang.String;


/**
 * Created by arolla on 14-11-21.
 */

public class ParseTxt{
    List<Pair<String,Double>> discountPromotionList;
    Map<String,Double> discountPromotionMap = new HashMap<String, Double>();
    List<String> secondHalfPricePromotionList;
    List<String> offXForEachYList;
    List<Pair<String,Double>> itemPriceList;
    Map<String,Double> itemPriceMap = new HashMap<String, Double>();
    List<Pair<String,Integer>> cartList;
    Map<String,Integer>  cartMap = new HashMap<String,Integer>() ;
//
//   public List<String> parse(String _path) throws IOException {
//       Path path = Paths.get(_path);
//       List<String> string = Files.readAllLines(path);
//       return string;
//   }
//    public Map<Object,Object> parse(String _path,String _delimiter) throws IOException {
//        Path path = Paths.get(_path);
//        List<String> stringList = parse(path.toString());
//        Map<Object,Object> map = new HashMap<Object,Object>();
//        for(String lines:stringList){
//            String  vector[] = lines.split(_delimiter);
//            if (vector[0]!= null)
//            {
//               map.put( vector[0],  vector[1]);
//            }
//          //  else
//            //  map.put(vector[0],"1");
//        }
//
//
//        return map;
//
//    }


    ParseTxt()
    {
        discountPromotionList = new LinkedList<Pair<String, Double>>();
        secondHalfPricePromotionList = new LinkedList<String>();
        offXForEachYList = new LinkedList<String>();
        itemPriceList = new LinkedList<Pair<String, Double>>();
        cartList = new LinkedList<Pair<String, Integer>>();
        discountPromotionMap = new HashMap<String, Double>();
        itemPriceMap = new HashMap<String, Double>();
        cartMap = new HashMap<String,Integer>() ;


    }

    ParseTxt(String _discountPromotionPath, String _secondHalfPricePromotionPath, String _offXForEachYPath, String _itemPriceListPath, String _cartTxtPath)throws IOException{
        discountPromotionList = new DiscountParse().parser(_discountPromotionPath);//("discount_promotion", ":");
        secondHalfPricePromotionList= new SecondHalfPriceParse().parser(_secondHalfPricePromotionPath);//("second_half_price_promotion");
        offXForEachYList= new OffXForEachYParse().parser(_offXForEachYPath);//("off_X_for_each_Y");
        itemPriceList = new ItemPriceListParse().parser(_itemPriceListPath);/* ("itemPriceList", ":"); */
        cartList = new CartListParse().parser(_cartTxtPath);


    }

    public void listToMap(){
        if (discountPromotionList.isEmpty()==false) {
            for (Pair<String, Double> lines : discountPromotionList) {
                discountPromotionMap.put(lines.getKey(), lines.getValue());
            }
        }
        if (itemPriceList.isEmpty()==false){
            for (Pair<String,Double> lines:itemPriceList){
                 itemPriceMap.put(lines.getKey(),lines.getValue());
            }
        }

    }
    public void handleCartList() throws IOException {



      //  List<String> cartList = parse(cartTxtPath);

        for(Pair<String,Integer> lines:cartList){

            if (lines == null) break;

            if (cartMap.containsKey(lines.getKey()) == false)
                cartMap.put(lines.getKey(),lines.getValue());
            else
            {
                int i = cartMap.get(lines.getKey());
                cartMap.put(lines.getKey(),lines.getValue()+i);
            }



        }


    //    double totalPriceWithoutPromotions = 0.0;
     //   double totalPriceWithPromotions = 0.0;



    }





}

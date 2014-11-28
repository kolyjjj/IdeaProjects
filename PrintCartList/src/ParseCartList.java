import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.*;
import java.lang.String;


/**
 * Created by arolla on 14-11-21.
 */

public class ParseCartList implements Parse{
    Map<Object,Object> discountPromotionMap;
    List<String> secondHalfPricePromotionList;
    List<String> offXForEachYList;
    Map<Object,Object> itemPriceListMap;
    Map<String,Integer> cartListMap;

   public List<String> parse(String _path) throws IOException {
       Path path = Paths.get(_path);
       List<String> string = Files.readAllLines(path);
       return string;
   }
    public Map<Object,Object> parse(String _path,String _delimiter) throws IOException {
        Path path = Paths.get(_path);
        List<String> stringList = parse(_path);
        Map<Object,Object> map = new HashMap<Object,Object>();
        for(String lines:stringList){
            String  vector[] = lines.split(_delimiter);
            if (vector[0]!= null)
            {
               map.put( vector[0],  vector[1]);
            }
          //  else
            //  map.put(vector[0],"1");
        }


        return map;

    }

    ParseCartList(String _discountPromotionPath,String _secondHalfPricePromotionPath,String _offXForEachYPath,String _itemPriceListPath,String _delimiter)throws IOException{
        discountPromotionMap = parse(_discountPromotionPath,_delimiter);//("discount_promotion", ":");
        secondHalfPricePromotionList= parse(_secondHalfPricePromotionPath);//("second_half_price_promotion");
        offXForEachYList= parse(_offXForEachYPath);//("off_X_for_each_Y");
        itemPriceListMap = parse(_itemPriceListPath,_delimiter);//("itemPriceList", ":");

    }


    public void handleCartList(String cartTxtPath) throws IOException {



        List<String> cartList = parse(cartTxtPath);
       cartListMap = new HashMap<String,Integer>() ;
        for(String lines:cartList){

            if ((lines == null)||(lines.length()==0) )break;
            String itemId = lines.substring(0,10);
            if (lines.length() == 10){
                if (cartListMap.containsKey(itemId) == false)
                    cartListMap.put(itemId,1);
                else cartListMap.put(itemId,cartListMap.get(itemId)+1);

            }
            else if (lines.length() > 10)
            {
                String itemCount = lines.substring(11);
                if (cartListMap.containsKey(itemId) == false)
                    cartListMap.put(itemId,Integer.parseInt(itemCount));
                else cartListMap.put(itemId,cartListMap.get(itemId)+Integer.parseInt(itemCount));


            }

        }


    //    double totalPriceWithoutPromotions = 0.0;
     //   double totalPriceWithPromotions = 0.0;



    }





}

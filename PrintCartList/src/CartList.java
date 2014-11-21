import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.*;
import java.lang.String;


/**
 * Created by arolla on 14-11-21.
 */

public class CartList {
    private String filePath;
    CartList (String _filePath)
    {
        filePath = _filePath;

    }

    public void handleCartList()
    {
        Map<String,Double> itemListMap = new HashMap<String,Double> () ;
        Set<String> secondHalfPricePromotionSet = new HashSet<String>();
        Map<String,Double> discountPromotionMap = new HashMap<String,Double> () ;
        Map<String,Integer> cartListMap = new HashMap<String,Integer>() ;

        double totalPriceWithoutPromotions = 0.0;
        double totalPriceWithPromotions = 0.0;

        try {
            String encoding = "UTF-8";
            File file  = new File("/home/arolla/IdeaProjects/PrintCartList/itemList");
            if (file.isFile()&&file.exists()){
                InputStreamReader read = new InputStreamReader(new FileInputStream (file),encoding);
                BufferedReader in = new BufferedReader(read);
                //String s = new String();
                while (true)//((s = in.readLine()) != null)
                {

                   // String itemId = new String();
                    //String itemPrice = new String();
                    String s = in.readLine();
                   // System.out.println(s);
                    if ((s == null)||(s.length()==0) )break;
                    String itemId = s.substring(0,10);
                    String  itemPrice = s.substring(11);
                    //System.out.println(itemId+' '+itemPrice);

                    itemListMap.put(itemId,Double.parseDouble(itemPrice));
                }

            }
        }catch (IOException e){
            System.out.println(e);
        }

        try {
            String encoding = "UTF-8";
            File file  = new File("/home/arolla/IdeaProjects/PrintCartList/discount_promotion");
            if (file.isFile()&&file.exists()){
                InputStreamReader read = new InputStreamReader(new FileInputStream (file),encoding);
                BufferedReader in = new BufferedReader(read);
                //String s = new String();
                while(true) //((s = in.readLine()) != null)
                {

                   // String itemId = new String();
                   // String itemDiscount = new String();
                    String s = in.readLine();
                    if ((s == null)||(s.length()==0) ) break;
                    String itemId = s.substring(0,10);
                    String itemDiscount = s.substring(11);
                    discountPromotionMap.put(itemId,Double.parseDouble(itemDiscount)/100.0);
                }

            }
        }catch (IOException e){
            System.out.println(e);
        }

        try {
            String encoding = "UTF-8";
            File file  = new File("/home/arolla/IdeaProjects/PrintCartList/second_half_price_promotion");
            if (file.isFile()&&file.exists()){
                InputStreamReader read = new InputStreamReader(new FileInputStream (file),encoding);
                BufferedReader in = new BufferedReader(read);
                //String s = new String();
                while (true)//((s = in.readLine()) != null)
                {
                    String s = in.readLine();
                    if ((s == null)||(s.length()==0) ) break;
                    String  itemId = s.substring(0,10);
                    secondHalfPricePromotionSet.add(itemId);
                  //  System.out.println(itemId);//ceshi

                }

            }
        }catch (IOException e){
            System.out.println(e);
        }







        try {
            String encoding = "UTF-8";
            File file  = new File(filePath);

            if (file.isFile()&&file.exists()){
                InputStreamReader read = new InputStreamReader(new FileInputStream (file),encoding);
                BufferedReader in = new BufferedReader(read);
               //String s ;
              //  String itemId =  new String() ;
              //  String itemCount = new String();
                while (true)//((s = in.readLine()) != null)
                {
                    //System.out.println(s);//ceshi

                    //String itemId =  new String() ;
                   // String itemCount = new String();
                    String s = in.readLine();
                    if ((s == null)||(s.length()==0) )break;
                    String itemId = s.substring(0,10);
                    //System.out.println(s.length());//ceshi
                    if (s.length() == 10){
                        if (cartListMap.containsKey(itemId) == false)
                            cartListMap.put(itemId,1);
                        else cartListMap.put(itemId,cartListMap.get(itemId)+1);

                    }
                    else if (s.length() > 10)
                    {
                      String itemCount = s.substring(11);
                       // System.out.println(itemCount);//ceshi
                        if (cartListMap.containsKey(itemId) == false)
                            cartListMap.put(itemId,Integer.parseInt(itemCount));
                        else cartListMap.put(itemId,cartListMap.get(itemId)+Integer.parseInt(itemCount));


                    }

                  //  System.out.println(itemId+' '+itemCount);//ceshi



                }

                System.out.println("购物明细   数量 单价 小计");
                Iterator e = cartListMap.entrySet().iterator();
                while(e.hasNext())
                {
                    Map.Entry entry = (Map.Entry) e.next();
                    Item item = new Item(entry.getKey().toString(), itemListMap.get(entry.getKey().toString()));
                    //System.out.println(entry.getKey().toString());//ceshi
                    if (discountPromotionMap.containsKey(item.getId()))
                    {
                        item.setDiscount(discountPromotionMap.get(item.getId()));
                    }
                    if (secondHalfPricePromotionSet.contains(item.getId()))
                    {
                        item.setIsHasSecondHalfPricePromotion(true);

                    }
                    item.setCount(Integer.parseInt(entry.getValue().toString()));

                    item.printData();

                    totalPriceWithoutPromotions += item.getPriceWithoutPromotions();
                    totalPriceWithPromotions += item.getPriceWithPromotions();


                }
                System.out.println("总计金额 优惠前  优惠后  优惠差");
                System.out.print(totalPriceWithPromotions);
                System.out.print("   ");
                System.out.print(totalPriceWithoutPromotions);
                System.out.print("  ");
                System.out.print(totalPriceWithPromotions);
                System.out.print("  ");
                System.out.print(totalPriceWithoutPromotions);




            }
        }catch (IOException e){
            System.out.println();
        }


    }





}

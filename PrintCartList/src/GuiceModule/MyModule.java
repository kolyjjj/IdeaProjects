package GuiceModule;


import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;


public class MyModule implements Module {
    @Override
    public void configure(Binder binder) {

        binder.bind(String.class).annotatedWith(Names.named("Discount txt Name")).toInstance("discount_promotion");
        binder.bind(String.class).annotatedWith(Names.named("OffXForEachY txt Name")).toInstance("off_X_for_each_Y");
        binder.bind(String.class).annotatedWith(Names.named("SecondHalfPrice txt Name")).toInstance("second_half_price_promotion");
        binder.bind(String.class).annotatedWith(Names.named("Cart txt Name")).toInstance("cart");
        binder.bind(String.class).annotatedWith(Names.named("ItemPriceList txt Name")).toInstance("itemPriceList");



    }

}


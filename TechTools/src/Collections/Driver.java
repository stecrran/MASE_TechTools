package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver {

    public static void main(String[] args) {

        List<Order> orders = new ArrayList<Order>();

        MarketOrder order1 = new MarketOrder("XXX", 11, "ABC");
        MarketOrder order2 = new MarketOrder("YYY", 33, "DEF");
        MarketOrder order3 = new MarketOrder("ZZZ", 44, "GHI");
        LimitOrder order4 = new LimitOrder("GGG", 55, "JKL");
        LimitOrder order5 = new LimitOrder("HHH", 22, "MNO");

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);

        for (Order order : orders) {
            System.out.println(order);
        }

       Collections.sort(orders);

        System.out.println("After:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}


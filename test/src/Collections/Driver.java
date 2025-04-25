package Collections;

import java.util.*;

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

//        Collections.sort(orders);

//        for (Order order : orders) {
//            System.out.println(order);
//        }
//
//        orders.sort(Comparator.comparingInt(Order::getAmount));
//        System.out.println("After sorting");
//        for (Order order : orders) {
//            System.out.println(order);
//        }

        Set<Order> orderSet = new TreeSet<Order>();
        orderSet.add(order1);
        orderSet.add(order2);
        orderSet.add(order3);
        orderSet.add(order4);
        orderSet.add(order5);

//        for (Order order : orderSet) {
//            System.out.println(order);
//        }

        Map<String, Order> orderMap = new TreeMap<>();

        for (Order order : orders) {
            orderMap.put(order.getSymbol(), order);
        }

        orderMap.forEach((symbol, order) -> {
            System.out.println("Key:" + symbol + " Amount:" + order.getAmount());
        });


    }
}




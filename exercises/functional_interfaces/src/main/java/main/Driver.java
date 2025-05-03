package main;


import domain.LimitOrder;
import domain.MarketOrder;
import domain.Order;


import java.util.ArrayList;
import java.util.List;

import static domain.Currency.*;
import static domain.Side.BUY;
import static domain.Side.SELL;

public class Driver {

    public static void main(String[] args) {
        List<Order> orders = createOrders();


    }


    private static List<Order> createOrders(){
        List<Order> orders = new ArrayList<>();

        Order order = new LimitOrder(EUR, 1000000.0, BUY , 1.45);
        orders.add(order);
        order = new MarketOrder(EUR, 2100000.0, SELL);
        orders.add(order);
        order = new MarketOrder(EUR, 2000000.0, BUY);
        orders.add(order);
        order = new MarketOrder(EUR, 3000000.0, BUY);
        orders.add(order);

        order = new MarketOrder(USD, 1200000.0, SELL);
        orders.add(order);
        order = new MarketOrder(USD, 3400000.0, BUY);
        orders.add(order);

        order = new MarketOrder(JPY, 2300000.0, SELL);
        orders.add(order);
        order = new MarketOrder(JPY, 9800000.0, BUY);
        orders.add(order);

        order = new MarketOrder(GBP, 6500000.0, SELL);
        orders.add(order);
        order = new MarketOrder(GBP, 4500000.0, BUY);
        orders.add(order);

        return orders;
    }
}

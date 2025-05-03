package main;


import domain.LimitOrder;
import domain.MarketOrder;
import domain.Order;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static domain.Currency.EUR;
import static domain.Currency.USD;
import static domain.Currency.GBP;
import static domain.Currency.JPY;
import static domain.Side.BUY;
import static domain.Side.SELL;

import static java.util.Comparator.comparing;

public class Driver {

    public static void main(String[] args) {
        List<Order> orders = createOrders();

        System.out.println("\nBuy side orders");
        printMatchedOrders(orders, o -> o.getSide() == BUY);

        System.out.println("\nSell side orders");
        printMatchedOrders(orders, o -> o.getSide() == SELL);

        System.out.printf("%nAverage order amount is %f%n", averageOrder.apply(orders));

        // Bonus for functional interfaces exercise

        System.out.println("\nOrders sorted by amount ascending");
        Collections.sort(orders, comparing(Order::getAmount));
        orders.forEach(System.out::println);

        System.out.println("\nOrders sorted by amount decending");
        Collections.sort(orders, comparing(Order::getAmount).reversed());
        orders.forEach(System.out::println);

        // Working with streams solutions start here

        System.out.println("\nBuy side orders using stream");
        orders.stream()
                .filter(o -> o.getSide() == BUY)
                .forEach(System.out::println);

        System.out.println("\nBuy side orders using stream sorted in ascending order");
        orders.stream()
                .filter(o -> o.getSide() == BUY)
                .sorted(comparing(Order::getAmount))
                .forEach(System.out::println);

        System.out.println("\nOrder amounts using map()");
        orders.stream()
                .map(Order::getAmount)
                .forEach(System.out::println);


        double totalAmountOfAllOrders = orders.parallelStream()
                .mapToDouble(Order::getAmount)
                .sum();

        System.out.printf("%nTotal amount of all orders %f%n", totalAmountOfAllOrders);

        long numberOfOrders = orders.stream()
                .count();
        System.out.printf("%nTotal number of orders in stream %d%n", numberOfOrders);


        List<Order> buySideOrders = orders.stream()
                .filter(o -> o.getSide() == BUY)
                .collect(Collectors.toList());

        System.out.println("\nBuy side orders using collector");
        buySideOrders.stream().forEach(System.out::println);


        // Streams bonus

        System.out.println("\nInteger stream using range");
        IntStream.range(1, 10).forEach(System.out::println);

        System.out.println("\nInteger stream using range closed");
        IntStream.rangeClosed(1, 10).forEach(System.out::println);


        System.out.println("\nValues read from file stream");
        try(Stream<String> lines = Files.lines(Paths.get(Driver.class.getClassLoader()
                .getResource("orders.csv").toURI()))){
            lines.forEach(System.out::println);
        }catch(Exception e){
            System.out.println(e.toString());
        }

    }

    private static Function<List<Order>, Double> averageOrder = x -> {
        double total = 0.0;
        for(Order order: x) {
            total+= order.getAmount();
        }
        return total/x.size();
    };


    private static void printMatchedOrders(List<Order> orders, Predicate<Order> predicate){
        orders.forEach(o-> {
            if (predicate.test(o)) {
                System.out.println(o);
            }
        });
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

package main;

import static domain.Currency.EUR;
import static domain.Currency.GBP;
import static domain.Currency.JPY;
import static domain.Currency.USD;
import static domain.Side.BUY;
import static domain.Side.SELL;

import java.util.ArrayList;
import static java.util.Comparator.*;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;


import domain.Currency;
import domain.LimitOrder;
import domain.MarketOrder;
import domain.Order;
import domain.Side;


public class Driver {

	public static void main(String[] args) {

		// Part 1
		
		Stream.of("a", "b","c","d","e")
			.map(s-> {
				System.out.println("map : " + s);
				return s.toUpperCase();
			})
			.filter(s-> {
				System.out.println("filter: " + s);
				return s.startsWith("A");
			})
			.forEach(s-> System.out.println("forEach: " +s));

	
		// Part 2
		
		System.out.printf("%n%nFilter first provides %n");
		
		Stream.of("a", "b","c","d","e")
			.filter(s-> {
				System.out.println("filter: " + s);
				return s.startsWith("a");
			})
			.map(s-> {
				System.out.println("map : " + s);
				return s.toUpperCase();
			})
			.forEach(s-> System.out.println("forEach: " +s));
		
		
		// Part 3  Grouping orders by Side
		
		
		List<Order> orders = createOrders();
		
		
		Map<Side, List<Order>> ordersBySide = orders.
				stream()
				.collect(Collectors.groupingBy(Order::getSide));
		
		System.out.println("Orders grouped by side ");
		ordersBySide.forEach((side, o)-> System.out.printf("%s:  %s%n", side, o));
		

		
		// Part 4 Order amounts per currency
		
		Map<Currency, Double> orderTotalByCurrency = orders.
				stream()
				.collect(groupingBy(Order::getCurrency,summingDouble(Order::getAmount) ));
		
		System.out.println("\nOrder total per currency ");
		orderTotalByCurrency.forEach((c, a)-> System.out.printf("%s: total order value %.2f%n", c, a));

		
		
		
		// Part 5 Average order value
		
		Double averageOrderAmount = orders
				.stream()
				.collect(Collectors.averagingDouble(o-> o.getAmount()));
		
		System.out.printf("%nAverage amount of each order is %.2f %n", averageOrderAmount);
		
		
		// Part 6 Summarizing statistics
		
		DoubleSummaryStatistics amountSummary = orders
				.stream()
				.collect(Collectors.summarizingDouble(o-> o.getAmount()));
		
		System.out.printf("Order Amount Summary %s %n", amountSummary);

		
		
		// Part 7 Maximum Order Per Currency
		
		Map<Currency, Optional<Order>> maxOrderByCurrency = orders.
				stream()
				.collect(Collectors.groupingBy(Order::getCurrency,maxBy(comparing(Order::getAmount)) ));
		
		System.out.println("\n\nMaximum order per currency ");
		maxOrderByCurrency.forEach((c, a)-> System.out.printf("%s: maximum order value %.2f%n", c, a.isPresent() ? a.get().getAmount() :0.0));
		
		
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

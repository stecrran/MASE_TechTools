package app;

import java.util.List;

import domain.Trader;
import domain.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;

public class Driver {


    public static void main(String[] args) {
        Trader dave = new Trader("Dave", "Athlone");
        Trader jayne = new Trader("Jayne", "London");
        Trader fiona = new Trader("Fiona", "New York");
        Trader alan = new Trader("Alan", "Athlone");


        List<Transaction> transactions = Arrays.asList(
                new Transaction(alan, 2011, 300),
                new Transaction(dave, 2012, 1000),
                new Transaction(dave, 2011, 400),
                new Transaction(jayne, 2012, 710),
                new Transaction(jayne, 2012, 700),
                new Transaction(fiona, 2012, 950)
        );
        // 2.
//       	List<Transaction> sortedFor2011 = transactions.stream().
//       			filter(t -> t.getYear()==2011).
//       			sorted().collect(Collectors.toList());
//       	
//       	for (Transaction transaction : sortedFor2011) {
//       		System.out.println(transaction);
//       	}
        
        List<Trader> traders = new ArrayList<>();
        traders.add(dave);        
        traders.add(jayne);        
        traders.add(fiona);        
        traders.add(alan);       
        // 3.
//        List<String> cities = traders.stream().map(t -> t.getCity()).distinct().collect(toList());
//        System.out.println(cities);
        
        // do this directly using flatMap
//      List<List<Transaction>> transactionList = Arrays.asList(transactions);
//      List<String> uniqueCities = transactionList.stream().flatMap(list -> list.stream())
//      		.map(t -> t.getTrader().getCity()).distinct().collect(Collectors.toList());
//      
//      uniqueCities.forEach(city -> System.out.println(city));
       	
        //4.
        List<Trader> athloneTraders = traders.stream().filter(t -> t.getCity().
        		equals("Athlone")).sorted(Comparator.comparing(t -> t.getName())).collect(toList());
        //athloneTraders.stream().forEach(t -> System.out.println("Athlone Trader: " + t.getName()));
        
        
        // Stream.of()
        //Stream.of(new String[]{"A","B","C"}).forEach(System.out::println);
        
        // how to use String arr[] directly
//        String[] arr = new String[]{"A","B","C"};
//        Stream.of(arr).forEach(s -> System.out.println(s));
        
        // 5.
        // do .map first, no comparator is needed as you are comparing Strings
//        String names = traders.stream().map(t -> t.getName()).
//        		sorted().collect(Collectors.joining());
//        
//        System.out.println(names);
        
        // 6.
//        List<Trader> dublinTraders = traders.stream().filter(t -> t.getCity().equals("Dublin")).collect(toList());
//        
//		if (dublinTraders.isEmpty()) {
//			System.out.println("No Dublin Traders.");
//		} else {
//			System.out.println(dublinTraders);
//		}
        
        // 7.
//        transactions.stream().filter(t -> t.getTrader().getCity().equals("Athlone"))
//        .forEach(t -> System.out.println("Trader " + t.getTrader().getName() + " has value: " + t.getValue() + " during " + t.getYear()));
        
        // 8.
//        OptionalDouble maxValue = transactions.stream().mapToDouble(t -> t.getValue()).max();
//        if (maxValue.isPresent()) {
//        	System.out.println("Max value of all transactions = " + maxValue.getAsDouble());
//        } else {
//        	System.out.println("no max.");
//        }
//        
//        
        OptionalDouble minValue = transactions.stream().mapToDouble(t -> t.getValue()).min();
//        if (minValue.isPresent()) {
//        	System.out.println("Max value of all transactions = " + minValue.getAsDouble());
//        } else {
//        	System.out.println("no min.");
//        }
        
        // 9.
        transactions.stream().sorted(Comparator.comparing(t -> t.getValue())).
        filter(t -> t.getValue()==minValue.getAsDouble()).forEach(t -> System.out.println(t));;
        
    }
}

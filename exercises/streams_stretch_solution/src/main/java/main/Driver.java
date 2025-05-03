package main;

import java.util.List;

import domain.Trader;
import domain.Transaction;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

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

        System.out.println("All transactions in 2011 sorted by value\n");

        List<Transaction> transactions2011 =
                transactions.stream()
                        .filter(transaction -> transaction.getYear() == 2011)
                        .sorted(comparing(Transaction::getValue))
                        .collect(toList());

        transactions2011.forEach(System.out::println);



        System.out.println("\nUnique cities where traders work\n");


        List<String> cities =
                transactions.stream()
                    .map(transaction -> transaction.getTrader().getCity())
                    .distinct()
                    .collect(toList());

        cities.forEach(System.out::println);


        System.out.println("\nAll traders from Athlone sorted by name\n");


        List<Trader> traders =
                transactions.stream()
                    .map(Transaction::getTrader)
                    .filter(trader -> trader.getCity().equals("Athlone"))
                    .distinct()
                    .sorted(comparing(Trader::getName))
                    .collect(toList());

        traders.forEach(System.out::println);

        System.out.println("\nAll traders names sorted alphabetically\n");

        String traderString =
                transactions.stream()
                    .map(transaction -> transaction.getTrader().getName())
                    .distinct()
                    .sorted()
                    .reduce("",(n1,n2)->n1+n2);

        System.out.println(traderString);

        System.out.println("\nAll traders names sorted alphabetically using joining\n");

        String traderStringJoining =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .collect(joining());

        System.out.println(traderStringJoining);


        System.out.println("\nAny traders from Dublin?");

        boolean dublinTraders =
                transactions.stream()
                    .anyMatch(transaction -> transaction.getTrader().getCity().equals("Dublin"));

        System.out.println(dublinTraders ? "Dublin traders found" : "No Dublin traders found");


        System.out.println("\nAll transaction values from all traders in Athlone");

        transactions.stream()
                .filter(transaction -> "Athlone".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);


        System.out.println("\nHighest value of all transactions");

        Optional<Integer> highestTransaction =
            transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        System.out.println(highestTransaction.get());

        System.out.println("\nLowest value transaction object");

        Optional<Transaction> lowestTransaction =
                transactions.stream()
                        .min(comparing(Transaction::getValue));

        System.out.println(lowestTransaction.get());


    }
}

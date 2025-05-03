package main;

import java.util.List;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Driver {


    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,2,3,4,5);
        List<String> strings = Arrays.asList("Hello ", "World ", "What ", "is ", "your ", "name? ");
        List<String> words = Arrays.asList("Hello ", "World ", "And", "Any", "All", "About");


        System.out.printf("Average of numbers is %.2f%n", average(integers));

        upperCase(strings).forEach(System.out::print);
        System.out.println("\n");


        searchStrings(words).forEach(System.out::println);

        System.out.println(getString(integers));
    }

    public static Double average(List<Integer> ints){
        return ints.stream()
                .mapToInt(i->i)
                .average()
                .getAsDouble();
    }

    public static List<String> upperCase(List<String> list){
        return list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static List<String> searchStrings(List<String> list){
        return list.stream()
                .filter(s->s.startsWith("A"))
                .filter(s->s.length() == 3)
                .collect(Collectors.toList());
    }

    public static String getString(List<Integer> list){
        return list.stream()
                .map(i->i%2 ==0 ? "e"+i : "o"+i)
                .collect(joining(","));
    }

}

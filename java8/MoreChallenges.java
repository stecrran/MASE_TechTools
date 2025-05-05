package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoreChallenges {
	
	public static void main(String[] args) {
		List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
//		nums.stream().filter(i -> i%2==0).forEach(System.out::println);
//		
//		List<String> words = List.of("hello", "java", "streams");
//		words.stream().forEach(s -> System.out.println(s.toUpperCase()));
//		
//		List<Integer> numbers = List.of(5, 12, 20, 8, 3, 15);
//		numbers.stream().filter(i -> i > 10).forEach(System.out::println);
//		
//		List<Integer> numbers = List.of(5, 12, 20, 8, 3, 15);
//		int sum = numbers.stream().mapToInt(i -> i).sum();
//		System.out.println("Sum of numbers = " + sum);
//		
//		List<String> words = List.of("hello", "java", "streams");
//		words.stream().sorted().forEach(System.out::println);
//		
//		List<Integer> numbers = List.of(5, 12, 20, 8, 3, 15);
//		numbers.stream().limit(3).forEach(System.out::println);
		
//		List<List<String>> nested = List.of(List.of("a", "b"), List.of("c", "d"));
//		List<String> stringList = nested.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
//		stringList.stream().forEach(System.out::println);
//		// or use one expression
//		nested.stream().flatMap(list -> list.stream()).collect(Collectors.toList()).forEach(System.out::println);
		
//		List<List<String>> nestedStrings = List.of(List.of("goat", "badger"), List.of("horse", "donkey"));
//		nestedStrings.stream().flatMap(list -> list.stream()).sorted().forEach(System.out::println);
		
		List<String> listOfStrings = Arrays.asList("one", "two", "three", "four", "five", "six", "seven");
		
//		Stream<String> test = listOfStrings.stream().sorted((a,b) -> b.length()-a.length());
//		
//		System.out.println(test.findFirst().get());
//		
//		// Find the longest string in a list
//		listOfStrings.stream().max(Comparator.comparingInt(s -> s.length())).ifPresent(System.out::println);
		
		// Join a list of strings into a single comma-separated string
//		System.out.println(listOfStrings.stream().collect(Collectors.joining(",")));
		
		List<Person> people = List.of(
			new Person("Jimmy",22),
			new Person("George", 45),
			new Person("Sally", 33),
			new Person("Bob", 88),
			new Person("Igor", 55),
			new Person("Max", 44),
			new Person("Lisa", 70)
		);
		
//		System.out.println(people.stream()
//				.collect(Collectors.groupingBy(p -> p.getAge())));
//		
//		// sort by age using key and value
//		people.stream()
//		.collect(Collectors.groupingBy(p -> p.getAge()))
//		.entrySet().stream()
//	    .sorted(Map.Entry.comparingByKey()) // sort by age (ascending)
//	    .forEach(entry -> {
//	        System.out.println("Age: " + entry.getKey());
//	        entry.getValue().forEach(System.out::println);
//	    });
		
		// Find the product of all integers in a list using reduce().
//		int productOfNums = nums.stream().reduce(1, (a,b) -> a*b);
//		System.out.println(productOfNums);
		
		
		// what about Maps <K,V>?
//		Map<String, Integer> productSales = Map.of(
//			    "Apples", 120,
//			    "Bananas", 45,
//			    "Cherries", 80,
//			    "Dates", 30,
//			    "Elderberries", 55
//			);
//		
//		// Use Java Streams to find and print the names of all products that sold more than 50 units, 
//		// sorted alphabetically.
//		productSales.entrySet().stream().filter(s -> s.getValue() > 50).forEach(System.out::println);
		
		// Partition a list of numbers into even and odd using Collectors.partitioningBy().
//		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//		Map<Boolean, List<Integer>> partitioned = numbers.stream()
//			    .collect(Collectors.partitioningBy(n -> n % 2 == 0));
//
//			System.out.println("Even numbers: " + partitioned.get(true));
//			System.out.println("Odd numbers: " + partitioned.get(false));
		
        // Given a list of Person objects, sort the list first by name alphabetically, 
        // and then by age (as a secondary sort if names are the same).
        List<Person> sortedPeople = people.stream()
        	    .sorted(Comparator.comparing(Person::getName)
        	                      .thenComparing(Person::getAge))
        	    .collect(Collectors.toList());

        	sortedPeople.forEach(System.out::println);

	}

}

class Person {
	
	String name;
	int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + ": Age: " + age;  
	}
	
}

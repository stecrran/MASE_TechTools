package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;


public class LambdaTest {

	public static void main(String[] args) {
		// Write a method that: 
		// - Takes a List<Integer> and Returns the average of the integers as a double
		List<Integer> testInts = Arrays.asList(1,2,3,4,5,6,7,8);
		//System.out.println(returnAverage(testInts));
		//System.out.println(returnUpperCase(Arrays.asList("a","b","c")));
		System.out.println(returnFilteredStrings(Arrays.asList("apple","orange","carrot","ant","bee","alf")));
		//System.out.println(testIntList(testInts));

	}
	
	public static double returnAverage(List<Integer> testInts) {
//		OptionalDouble average = testInts.stream().mapToDouble(i -> i).average();
//		if (average.isPresent()) {
//			return average.getAsDouble();
//		}
//		else {
//			return 0.0;
//		}
		return testInts.stream().mapToInt(i -> i).average().getAsDouble();
	}
	
	public static List<String> returnUpperCase(List<String> stringList){
		//return stringList.stream().map(s -> s.toUpperCase()).collect(toList()); // if using static import java.util.stream.Collectors.toList
		return stringList.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
	}
	
	public static List<String> returnFilteredStrings(List<String> stringList){
		return stringList.stream()
				.map(s -> s.toUpperCase())
				.filter(s -> s.startsWith("A"))
				.filter(s -> s.length() == 3)
				.collect(toList());
	}


	/* Write a method that:
	 *-Takes a List<Integer>
	 *-Returns a comma separated String based of the integers
	 *-With the integer prefixed with e if the number is even
         *-With the integer prefixed with o if the number is odd 
	*/
	public static String testIntList(List<Integer> listInts) {
//		String test = listInts.stream().filter(i -> {
//			return i % 2 != 0;
//		})
//		.map(i -> {
//			return "o" + i.toString();
//			
//		}).collect(Collectors.joining(","));
//		
//		test = listInts.stream().filter(i -> {
//			return i % 2 == 0;
//		})
//		.map(i -> {
//			return "e" + i.toString();
//			
//		}).collect(Collectors.joining(","));
//		
//		return test;
		return listInts.stream().map(i -> i % 2==0 ? "e"+i:"o"+i)
				.collect(Collectors.joining(","));
	}

}

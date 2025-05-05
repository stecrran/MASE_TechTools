package tus.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import static java.util.stream.Collectors.toList;


public class TestClass {

	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		OptionalDouble max = integers.stream().mapToDouble(i -> i).average();
		//System.out.println("Average: " + max.getAsDouble());
		
		List<String> strings = Arrays.asList("Apple", "Orange", "one", "two", "three", "four", "five", "Ant", "ant");
		//strings.stream().forEach(s -> System.out.println(s.toUpperCase()));
		
		//System.out.println(stringMethod(strings));

	}
	
	public static List<String> stringMethod(List<String> stringList){
		return stringList.stream().filter(s -> s.startsWith("A") && s.length()==3).collect(toList());
		
	}
	
	public static String returnCommaSeparatedString(List<Integer> intList) {

		intList.stream().mapToInt(i -> i).forEach(i ->
		{
			if(i % 2 !=0) {
				String result = "e" + i;
			}
			else {
				String result = "o" + i;
			}
		});
		return "";
	}
}

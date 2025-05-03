package demo.concurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Demo {
    public static void main(String[] args) {
        int [] array = IntStream.
                range(1,100)
                .toArray();

        Arrays.parallelPrefix(array, (x,y) -> 66);


        Arrays.stream(array).forEach(System.out::println);
    }
}

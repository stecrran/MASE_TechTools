package main;

import java.util.function.Function;
import java.util.stream.Stream;

public class Driver {

    public static long javaSevenSum(long n){
        long result = 0;
        for(long i=1L; i <= n; i++){
          result += i;
        }
        return result;
    }

    public static long sequentialSum(long n){
        return Stream.iterate(1L, i ->i+1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static long parallelSum(long n){
        return Stream.iterate(1L,i->i+1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long measureSumPerformance(Function<Long, Long> adder, long n){
        long fastest = Long.MAX_VALUE;
        for(int i=0; i< 10; i++){
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start)/1_000_000;
            System.out.println("Result: " + sum);
            if(duration < fastest) fastest = duration;
        }
        return fastest;
    }

    public static void main(String[] args) {

        System.out.println("Java 7 style sum done in " +
                measureSumPerformance(Driver::javaSevenSum,10_000_000) + " ms");

        System.out.println("Sequential stream sum done in " +
                        measureSumPerformance(Driver::sequentialSum,10_000_000) + " ms");

        System.out.println("Parrallel stream sum done in " +
                measureSumPerformance(Driver::parallelSum,10_000_000)+ " ms");

    }
}

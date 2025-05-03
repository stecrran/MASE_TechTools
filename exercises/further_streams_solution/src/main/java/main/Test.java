package main;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        System.out.println();
        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("a","b","c","d","e");

        streamSupplier.get()  //supplies a stream
                .forEach(s-> System.out.println("forEach: " + s));
        streamSupplier.get()
                .map(s -> s.toUpperCase())
                .forEach(s-> System.out.println("forEach: " + s));

    }
}




import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        List<String> currencies = Arrays.asList("USD", "JPY", "EUR", "HKD", "INR", "AUD");

        currencies.forEach((a) -> System.out.println(a));

/*
        Collections.sort(currencies, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println("In compare");
                return o1.compareTo(o2);
            }
        });
*/

        Collections.sort(currencies, (c1, c2) -> c1.compareTo(c2));


        System.out.println("\nSorted currencies in ascending order\n");
        currencies.forEach((a) -> System.out.println(a));

        Collections.sort(currencies, (c1, c2) -> -c1.compareTo(c2));

        System.out.println("\nSorted currencies in descending order\n");
        currencies.forEach((a) -> System.out.println(a));


        // Bonus

        new Thread(()->{
            for(int i=1; i<11; i++){
                System.out.println(i);
            }

        }).start();

    }
}


public class SimpleMath {

    private static double a = 0.5;
    private static double b =1.0;
    private static double c = 2.0;
    private static double d = 3.0;

    public static void main(String[] args) {
        System.out.println(a+b);
        System.out.println(d-c);
        System.out.println(c/a);
        System.out.println(b*d);
        System.out.println(a%d);

        double sum = ((a+b) + (d-c) + (c/a) + (b*d) + (a%d));

        System.out.println("Average of all values: " + sum / 5);
        System.out.println("value of a+b divided by c-d: " + (a+b)/(c-d));
    }


}

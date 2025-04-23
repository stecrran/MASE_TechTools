public class Math {


    public static double addDoubles(double... doubles){
        double total = 0;
        for (double aDouble : doubles) {
            total += aDouble;
        }
        return total;
    }

    public static double addInts(int... ints){
        int total = 0;
        for (int anInt : ints) {
            total += anInt;
        }
        return total;
    }
}

public class CalculatorDriver {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(4,2));
        System.out.println(calc.subtract(4,2));
        System.out.println(calc.divide(4,2));
        System.out.println(calc.multiply(4,2));
    }
}

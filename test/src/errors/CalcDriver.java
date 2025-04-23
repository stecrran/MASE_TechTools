package errors;

public class CalcDriver {

    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
//        try {
//            System.out.println(calc.add(1000, 10));
//        }
//        catch (CalculatorException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//        System.out.println(calc.subtract(4,2));
       System.out.println(calc.divide(4,0));
//        System.out.println(calc.multiply(4,2));
    }

}

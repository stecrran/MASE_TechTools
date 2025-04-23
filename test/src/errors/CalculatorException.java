package errors;

public class CalculatorException extends Exception {

    public CalculatorException(String message) {
        System.out.println("Error: " + message);
    }
}

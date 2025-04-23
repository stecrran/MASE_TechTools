package errors;

public class Calculator {

    public float add(float a, float b) throws Exception {
        if (a < -100 || a > 100 || b < -100 || b > 100){
            throw new CalculatorException("Outside Range (-100 to +100)");
        }
        return a + b;
    }

    public float subtract(float a, float b) throws Exception {
        if (a < -100 || a > 100 || b < -100 || b > 100){
            throw new CalculatorException("Outside Range (-100 to +100)");
        }
        return a - b;
    }

    public float divide(float a, float b) throws Exception {
        if (a < -100 || a > 100 || b < -100 || b > 100){
            throw new CalculatorException("Outside Range (-100 to +100)");
        }
        return a / b;
    }

    public float multiply(float a, float b) throws Exception {
        if (a < -100 || a > 100 || b < -100 || b > 100){
            throw new CalculatorException("Outside Range (-100 to +100)");
        }
        return a * b;
    }
}


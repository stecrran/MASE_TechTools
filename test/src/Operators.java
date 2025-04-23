import java.util.Scanner;

public class Operators {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter another number: ");
        int num2 = sc.nextInt();

        System.out.print("Enter am operator: ");
        int result = 0;
        String operator = sc.next();
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;

            default:
                System.out.println("Invalid operator");
                break;
        }

        System.out.print(num1 + operator + num2 + " = " + result);
    }
}

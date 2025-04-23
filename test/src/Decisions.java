import java.util.Scanner;

public class Decisions {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter a number (1 - 100): ");
        int num = sc.nextInt();

        int num1 = 0;
        int num2 = 0;

        if (num < 1 || num > 100) {
            System.out.println("Invalid number");
            System.exit(0);
        }

        else {
            if (num % 2 == 0) {
                System.out.println(num + " is an even number.");
            }
            else {
                System.out.println(num + " is an ddd number.");
            }
            num1 = num;
        }

        System.out.print("Enter another number (1 - 100): ");
        num2 = sc.nextInt();

        if (num2 == num1) {
            System.out.println(num1 + " is equal to " + num2);
        }

        else if (num1 > num2){
            System.out.println(num1 + " is greater than " + num2);
        }

        else {
            System.out.println(num2 + " is greater than " + num1);
        }


        System.out.println("Enter another number (1 - 9): ");
        int x = sc.nextInt();

        switch(x){
            case 1:
                System.out.print("One");
                break;
            case 2:
                System.out.print("Two");
                break;
            case 3:
                System.out.print("Three");
                break;
            case 4:
                System.out.print("Four");
                break;
            case 5:
                System.out.print("Five");
                break;
            case 6:
                System.out.print("Six");
                break;
            case 7:
                System.out.print("Seven");
                break;
            case 8:
                System.out.print("Eight");
                break;
            case 9:
                System.out.print("Nine");
                break;
            default:
                System.out.print("Not a number between 1 and 9.");
                break;
        }
    }

}

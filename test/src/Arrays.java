import java.util.Scanner;

public class Arrays {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter a number of students \n> ");
        int students = sc.nextInt();

        int[] studentArray = new int[students];
        int sum = 0;
        int highest = 0;
        int lowest = 100;

        for (int i = 0; i < studentArray.length; i++) {
            System.out.print("Enter student grade: ");
            studentArray[i] = sc.nextInt();
            sum += studentArray[i];

        }

        for (int i = 0; i < studentArray.length; i++) {
            System.out.println("student " + i + " has grade: " + studentArray[i]);
            if (studentArray[i] > highest) {
                highest = studentArray[i];
            }
            if (studentArray[i] < lowest) {
                lowest = studentArray[i];
            }
        }

        System.out.println("The average grade is " + (sum/studentArray.length));
        System.out.println("The highest grade is " + highest);
        System.out.println("The lowest grade is " + lowest);
    }
}

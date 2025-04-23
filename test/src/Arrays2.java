import java.util.Scanner;

public class Arrays2 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter a number of students \n> ");
        int students = sc.nextInt();

        int[][] studentArray = new int[students][3];

        for (int i = 0; i < studentArray.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter student " + (i+1) + " grade " + (j+1) + ": " );
                studentArray[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < studentArray.length; i++) {
            for (int j = 0; j < studentArray[i].length; j++) {
                System.out.println("Student " + (i+1) + " has grade: " + studentArray[i][j]);
            }
        }
    }
}

import java.util.Scanner;

public class Strings {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
//        System.out.println("Enter a string: ");
//        String s = sc.nextLine();
//
//        char[] charArray = s.toCharArray();
//        for (int i = charArray.length-1; i >= 0; i--) {
//            System.out.print(charArray[i]);
//        }
//        System.out.println("Enter a string: ");
//        String s = sc.nextLine();
//        int[] numbers = new int[s.length()];
//        char[] ch = s.toUpperCase().toCharArray();
//        for (int i = 0; i < ch.length; i++) {
//            if (ch[i] == 'A' || ch[i] == 'B' || ch[i] == 'C') {
//                numbers[i] = 2;
//            }
//            else if (ch[i] == 'D' || ch[i] == 'E' || ch[i] == 'F') {
//                numbers[i] = 3;
//            }
//            else if (ch[i] == 'G' || ch[i] == 'H' || ch[i] == 'I') {
//                numbers[i] = 4;
//            }
//            else if (ch[i] == 'J' || ch[i] == 'K' || ch[i] == 'L') {
//                numbers[i] = 5;
//            }
//            else if (ch[i] == 'M' || ch[i] == 'N' || ch[i] == 'O') {
//                numbers[i] = 6;
//            }
//            else if (ch[i] == 'P' || ch[i] == 'Q' || ch[i] == 'R' || ch[i] == 'S') {
//                numbers[i] = 7;
//            }
//            else if (ch[i] == 'T' || ch[i] == 'U' || ch[i] == 'V') {
//                numbers[i] = 8;
//            }
//            else if (ch[i] == 'W' || ch[i] == 'X' || ch[i] == 'Y' || ch[i] == 'Z') {
//                numbers[i] = 9;
//            }
//            else {
//                System.out.println("Not valid.");
//            }
//        }
//
//        for (int i = 0; i < numbers.length; i++) {System.out.print(numbers[i]);}

        System.out.println("Enter a string: ");
        String s = sc.nextLine();
        char[] charArray = s.toCharArray();

//        char[] reversedChars = new char[charArray.length];
//        for (int i = 1; i <= charArray.length; i++) {
//            reversedChars[i-1] = charArray[charArray.length-i];
//        }
//
//        String reverse = String.valueOf(reversedChars);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {sb.append(charArray[i]);}

        sb.reverse();
        String str = sb.toString();

        if (str.equals(s)) {
            System.out.println("This is a palindrome");
        }
        else {
            System.out.println("This is not a palindrome");
        }
    }
}

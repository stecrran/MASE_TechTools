package threads;

import java.util.Scanner;

public class Numbers implements Runnable {

    static Scanner sc = new Scanner(System.in);

    public void run(){
        System.out.print("Enter start number: ");
        int start = sc.nextInt();

        System.out.print("Enter end number: ");
        int end = sc.nextInt();

        System.out.print("Enter delay number: ");
        int delay = sc.nextInt();

        for(int i = start; i <= end; i++){
            try {
                System.out.println(i);
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}

package threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Producer implements Runnable {

    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        System.out.print("Enter some text (Please): ");
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        String text = null;

        try {
            while (!"end".equals(text)){
                text = reader.readLine();
                buffer.setData(text);
            }
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

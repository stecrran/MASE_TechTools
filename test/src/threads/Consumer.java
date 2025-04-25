package threads;

public class Consumer implements Runnable {

    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        String data = null;
        while(!("end".equals(data))) {
            data = buffer.getData();
            System.out.println("Read: " + data);
        }
        System.out.println("Consumer finished.");
    }

}

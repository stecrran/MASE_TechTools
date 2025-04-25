package threads;

public class Driver {

    public static void main(String[] args) {
//        Numbers numbers = new Numbers();
//        numbers.run();

        Buffer buffer1 = new Buffer();
        Buffer buffer2 = new Buffer();

        Producer t1 = new Producer(buffer1);
        Consumer t2 = new Consumer(buffer2);

        t1.run();
        t2.run();

    }

}

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    volatile static boolean result = true;
    static AtomicInteger ai = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new ThreadOne("Increment");
        Thread t2 = new ThreadTwo("Decrement");

        t1.start();
        t2.start();
    }
}

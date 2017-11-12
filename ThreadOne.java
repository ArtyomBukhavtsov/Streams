import java.util.Random;

public class ThreadOne extends Thread {
    private String name;

    public ThreadOne(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();

        System.out.println(name + " start");
        for (int i = 0; i < 100; i++) {
            System.out.println(Main.ai.get());
            Main.ai.incrementAndGet();
            if (i == 99 || Main.result == false) Thread.currentThread().interrupt();
            try {
                sleep(random.nextInt(200) + 50);
            } catch (InterruptedException e) {
                if (Main.result == true) {
                    Main.result = false;
                    System.out.println(name + " win");
                }
                break;
            }
        }
    }
}

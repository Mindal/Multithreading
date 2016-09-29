package ru.multithreading;

public class VolatilePlayer implements Runnable {
    private final String mine;
    private static volatile String current = "PONG";

    public VolatilePlayer(String mine) {
        this.mine = mine;
    }

    @Override
    public void run() {
        int i = 0;
        while (!Thread.currentThread().isInterrupted()) {
            while (current.equals(mine)) {
            }

            System.out.println(mine + " " + ++i);
            current = mine;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread pong = new Thread(new VolatilePlayer("PONG"));
        Thread ping = new Thread(new VolatilePlayer("PING"));
        pong.start();
        ping.start();
        Thread.sleep(100);
        pong.interrupt();
        ping.interrupt();
    }
}

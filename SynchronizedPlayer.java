package ru.multithreading;

public class SynchronizedPlayer implements Runnable {
    private final String mine;
    private static final Object lock = new Object();
    private static String current = "PONG";

    public SynchronizedPlayer(String mine) {
        this.mine = mine;
    }


    @Override
    public void run() {
        int i = 0;
        while (true) {
            synchronized (lock) {
                while (mine.equals(current)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e.getCause());
                    }

                }
                System.out.println(mine + ++i);
                current = mine;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread pong = new Thread(new SynchronizedPlayer("PONG"));
        Thread ping = new Thread(new SynchronizedPlayer("PING"));
        pong.start();
        ping.start();
    }


}

package ru.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentPlayer implements Runnable {
    private final String mine;
    private static String current = "PONG";
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    public ConcurrentPlayer(String mine) {
        this.mine = mine;
    }


    public static void main(String[] args) throws InterruptedException {
        Thread pong = new Thread(new ConcurrentPlayer("PONG"));
        Thread ping = new Thread(new ConcurrentPlayer("PING"));
        pong.start();
        ping.start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            lock.lock();
            try {
                while (mine.equals(current)) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e.getCause());
                    }
                }
                System.out.println(mine + ++i);
                current = mine;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }

    }
}

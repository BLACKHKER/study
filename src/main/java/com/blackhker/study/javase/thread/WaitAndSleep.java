package com.blackhker.study.javase.thread;

/**
 * @Author BLACKHKER
 * @Date 2023/4/26 10:06
 * @ClassName: SleepAndWait
 * @Description: 线程等待、线程休眠的区别
 * @Version 1.0
 */
public class WaitAndSleep {

    public static void main(String[] args) {

        // 创建同步锁对象
        final Object lock = new Object();

        // 创建线程一，执行打印后进入wait等待状态
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 在同步块内部调用wait方法
                synchronized (lock) {
                    System.out.println("start wait...");
                    try {
                        // 线程进入等待状态，释放锁
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("end wait...");
                }
            }
        }).start();

        /**
         * 匿名实现类转Lambda，
         * Runnable创建线程就是实现接口的实现类对象给Thread类作为创建对象的参数
         * 通过Lambda直接创建一个实例并实现run方法即可
         */
        // 线程二首先休眠三秒，用于判断线程一会不会结束wait等待执行打印end wait语句，然后唤醒线程二
        new Thread(() -> {
            try {
                Thread.sleep(3000); // 休眠3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 在同步块内部调用notify方法
            synchronized (lock) {
                // 唤醒使用该锁的、等待的线程，随机释放其中一个线程的锁
                lock.notify();
            }
        }).start();
    }
}

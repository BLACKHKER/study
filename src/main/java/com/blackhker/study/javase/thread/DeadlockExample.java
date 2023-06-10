package com.blackhker.study.javase.thread;

/**
 * @Author BLACKHKER
 * @Date 2023/6/10
 * @ClassName: DeadlockExample
 * @Description: 死锁
 * @Version 1.0
 */

/**
 * DeadlockExample类有两个方法 method1() 和 method2()，分别需要获取 lock1 和 lock2 两个对象的锁。
 * 当线程1执行 method1() 方法时，首先获取 lock1 的锁，然后尝试获取 lock2 的锁；
 * 而线程2执行 method2() 方法时，则是相反的顺序，首先获取 lock2 的锁，然后尝试获取 lock1 的锁。
 * 当线程1获取了 lock1 的锁之后，线程2获取了 lock2 的锁，但是由于两个线程都需要获取对方持有的锁，因此两个线程都无法继续执行下去，形成死锁。
 */
public class DeadlockExample {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                method1();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                method2();
            }
        });

        thread1.start();
        thread2.start();
    }

    public static void method1() {
        synchronized (lock1) {
            System.out.println("线程一获取到锁1");

            try {
                // 休眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock2) {
                System.out.println("线程二获取到锁2");
            }
        }
    }

    public static void method2() {
        synchronized (lock2) {
            System.out.println("线程二获取到锁2");

            try {
                // 休眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock1) {
                System.out.println("线程二获取到锁1");
            }
        }
    }
}
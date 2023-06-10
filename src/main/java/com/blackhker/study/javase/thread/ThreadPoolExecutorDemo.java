package com.blackhker.study.javase.thread;

import java.util.concurrent.*;

/**
 * @Author BLACKHKER
 * @Date 2023/6/8
 * @ClassName: ThreadPoolExecutorDemo
 * @Description: 线程池案例，注意单元测试会影响一些方法输出的结果，使用main函数解决该问题
 * @Version 1.0
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {

//        singleThreadExecutor();
//        fixedThreadPool();
//        cachedThreadPool();
//        scheduleThreadPool1();
//        scheduleThreadPool2();
        threadPoolExecutor();
    }

    /**
     * 单一线程池
     */
    public static void singleThreadExecutor() {

        // 创建单一线程池
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        // 循环提交10个任务执行
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        // 关闭线程池
        singleThreadExecutor.shutdown();
    }

    /**
     * 固定大小的线程池
     */
    public static void fixedThreadPool() {
        // 创建一个固定大小为3的线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        // 循环提交10个任务给线程池执行
        for (int i = 0; i < 10; i++) {
            final int index = i; // 定义一个final变量存储i的值
            // 将任务提交给线程池执行
            fixedThreadPool.execute(new Runnable() {
                // 实现Runnable接口的run方法来定义任务的具体执行逻辑
                @Override
                public void run() {
                    try {
                        System.out.println(index); // 输出任务编号
                        Thread.sleep(2000); // 模拟任务执行需要2秒的时间
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        // 关闭线程池
        fixedThreadPool.shutdown();
    }

    /**
     * 缓存线程池
     */
    public static void cachedThreadPool() {

        // 创建一个可缓存的线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        // 循环创建10个任务
        for (int i = 0; i < 10; i++) {
            // 为每个任务创建一个索引
            final int index = i;
            try {
                // 让线程休眠一段时间，以便观察执行顺序
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 提交任务到线程池中
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    // 输出任务的索引
                    System.out.println(index);
                    // 输出当前线程池中的线程数
                    ThreadPoolExecutor executor = (ThreadPoolExecutor) cachedThreadPool;
                    System.out.println("当前线程池中线程的数量：" + executor.getPoolSize());
                }
            });
        }

        // 关闭线程池
        cachedThreadPool.shutdown();
    }

    /**
     * 计划线程池，延迟x秒执行线程
     */
    public static void scheduleThreadPool1() {

        System.out.println("延迟3秒执行");

        // 创建一个大小为5的ScheduledExecutorService线程池
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

        // 延迟3秒后执行任务
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行线程");
            }
        }, 3, TimeUnit.SECONDS);

        // 关闭线程池
        System.out.println("关闭线程");
        scheduledThreadPool.shutdown();
    }

    /**
     * 延迟x秒-间隔y秒执行一次
     */
    // 定义一个方法，用于示例定时任务和周期性任务
    public static void scheduleThreadPool2() {

        System.out.println("延迟1秒后，每隔3秒执行一个任务");

        // 创建一个大小为5的ScheduledExecutorService线程池
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

        // 延迟1秒后，每隔3秒执行一个任务
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {

            int i = 0;

            @Override
            public void run() {
                // 判断计数器是否小于3
                if (i < 3) {
                    i++;
                    System.out.println("执行线程");
                } else {
                    // 如果计数器大于等于3，则关闭线程池，并打印关闭线程的消息
                    scheduledThreadPool.shutdown();
                    System.out.println("关闭线程");
                }
            }
        }, 1, 3, TimeUnit.SECONDS);
    }

    /**
     * 使用 ThreadPoolExecutor 创建线程池
     */
    public static void threadPoolExecutor() {

        int corePoolSize = 5; // 核心线程池大小
        int maxPoolSize = 10; // 最大线程池大小
        long keepAliveTime = 60L; // 空闲线程保持存活时间
        TimeUnit unit = TimeUnit.SECONDS; // 存活时间的单位
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);   // 任务队列

        // 创建一个包含1个线程的线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, unit, workQueue);

        // 循环创建10个任务
        for (int i = 1; i <= 10; i++) {
            // 为每个任务创建一个索引
            final int index = i;
            try {
                // 让线程休眠一段时间，以便观察执行顺序
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 添加一个Runnable任务到线程池
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index); // 输出任务编号
                        System.out.println("Task executed by " + Thread.currentThread().getName());
                        Thread.sleep(2000); // 模拟任务执行需要2秒的时间
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        // 关闭线程池
        executor.shutdown();
    }
}

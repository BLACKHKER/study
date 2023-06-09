package com.blackhker.study.javase.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author BLACKHKER
 * @Date 2023/6/8
 * @ClassName: ThreadPoolExecutorDemo
 * @Description: 线程池
 * @Version 1.0
 */
public class ThreadPoolExecutorDemo {

    @Test
    public void test() {
        this.fixedThreadPool();
    }

    /**
     * 缓存线程池
     */
    public void cachedThreadPool() {

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
    }

    /**
     * 固定大小的线程池
     */
    public void fixedThreadPool() {
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
    }
}

package com.blackhker.study.javase.thread;

/**
 * @Author BLACKHKER
 * @Date 2023/4/25 19:00
 * @ClassName: MyRunnable
 * @Description: 创建线程第二种：实现Runnable接口，实现run方法
 * @Version 1.0
 */
public class MyRunnable implements Runnable {

    /**
     * 线程执行该方法方法体中的内容
     */
    @Override
    public void run() {
        System.out.println("MyRunnable is running.");
    }

    public static void main(String[] args) {
        // 将Runnable实现类的实例传递给Thread类的构造函数并调用start()方法启动线程
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}

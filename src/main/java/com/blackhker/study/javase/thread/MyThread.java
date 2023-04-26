package com.blackhker.study.javase.thread;

/**
 * @Author BLACKHKER
 * @Date 2023/4/25 18:57
 * @ClassName: MyThread
 * @Description: 创建线程第一种：继承Thread类 ，重写run方法
 * @Version 1.0
 */
public class MyThread extends Thread {

    /**
     * 线程执行该方法方法体中的内容
     */
    @Override
    public void run() {
        System.out.println("MyThread is running.");
    }

    public static void main(String[] args) {
        // 创建子类(继承了Thread的类)对象，用该对象调用start方法启动线程
        MyThread thread = new MyThread();
        thread.start();
    }
}

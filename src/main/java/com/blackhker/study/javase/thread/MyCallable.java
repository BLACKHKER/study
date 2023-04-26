package com.blackhker.study.javase.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author BLACKHKER
 * @Date 2023/4/25 19:10
 * @ClassName: MyCallable
 * @Description: Runnable升级版：Callable，实现Callable接口,获取线程返回内容
 * 本例中，线程执行一个简单的循环计算，并返回计算结果。
 * @Version 1.0
 */
public class MyCallable implements Callable<Integer> {

    /**
     * 线程执行该方法方法体中的内容,该方法包含返回值(Integer类型)
     */
    @Override
    public Integer call() throws Exception {
        // 计算1-10的和
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
            // 模拟耗时操作
            Thread.sleep(100);
        }
        return sum; // 返回结果
    }

    public static void main(String[] args) {
        // 创建Callable实现类的实例
        MyCallable myCallable = new MyCallable();

        // 将实现类的实例放入FutureTask中，用于获取执行结果
        // FutureTask是一种可以获取Callable执行结果的容器
        FutureTask<Integer> task = new FutureTask<Integer>(myCallable);

        // 开启一个新的线程，该线程会在后台执行call方法中的代码，并返回call方法的执行结果
        Thread thread = new Thread(task);
        thread.start();

        try {
            // 调用get()方法获取FutureTask实例中存储的计算结果，该方法会阻塞当前线程，直到后台线程执行结束并返回结果
            // 由于在MyCallable中的计算过程中执行了Thread.sleep(100)语句，
            // 因此get()方法会阻塞至少100毫秒以等待计算结果。
            Integer result = task.get(); // 获取执行结果
            System.out.println("Result is " + result);  // 55
        } catch (InterruptedException | ExecutionException e) {
            // 捕获可能抛出的异常，并打印栈信息
            e.printStackTrace();
        }
    }
}
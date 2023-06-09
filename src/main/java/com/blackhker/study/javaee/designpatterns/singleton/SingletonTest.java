package com.blackhker.study.javaee.designpatterns.singleton;

/**
 * @Author BLACKHKER
 * @Date 2023/4/18 17:07
 * @ClassName: SingletonTest
 * @Description: 单例模式测试
 * @Version 1.0
 */
public class SingletonTest {
    public static void main(String[] args) {

        // 创建多线程检测
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Teacher.getTeacher3());
                }
            }).run();
        }

    }
}

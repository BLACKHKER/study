package com.blackhker.study.javaee.designpatterns.singleton;

import org.junit.Test;

/**
 * @Author BLACKHKER
 * @Date 2023/4/18 17:20
 * @ClassName: Teacher
 * @Description: 单例模式，基础懒汉式
 * @Version 1.0
 */
public class Teacher {

    // 创建静态成员变量，懒汉式在类加载时(程序启动时)不实例化
    private static Teacher teacher;

    // 私有化构造方法
    private Teacher() {
    }

    // 基础懒汉式单例模式
    public static Teacher getTeacher1() {
        // 懒汉式先判断是否已经创建对象了，如果没创建，才创建静态成员变量
        if (teacher == null) {
            teacher = new Teacher();
        }
        return teacher;
    }

    // Class锁机制解决多线程问题，这样每次只允许一个线程调用getInstance方法
    public static synchronized Teacher getTeacher2() {
        if (teacher == null) {
            teacher = new Teacher();
        }
        return teacher;
    }

    /*
        首先当一个线程发出请求后，会先检查instance是否为null，如果不是则直接返回其内容，这样避免了进入synchronized块所需要花费的资源。
	    其次，即使第2节提到的情况发生了，两个线程同时进入了第一个if判断，那么他们也必须按照顺序执行synchronized块中的代码，
	    第一个进入代码块的线程会创建一个新的Singleton实例，而后续的线程则因为无法通过if判断，而不会创建多余的实例。
	*/
    // double-checked locking，双检锁，优化性能
    public static Teacher getTeacher3() {
        if (teacher == null) {
            synchronized (teacher) {
                if (teacher == null) {
                    teacher = new Teacher();
                }
            }
        }
        return teacher;
    }

    /*
     * JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的。
     * 这样当我们第一次调用getTeacher4的时候，JVM能够帮我们保证teacher只被创建一次;
     * 并且会保证把赋值给teacher的内存初始化完毕，这样我们就不用担心JVM中的问题。
     * 此外该方法也只会在第一次调用的时候使用互斥机制，这样就解决了双检锁中的低效问题。
     * 最后teacher是在第一次加载Teacher类时被创建的，而TeacherContainer类则在调用getTeacher4方法的时候才会被加载，因此也实现了惰性加载。
     *
     * */
    // 内部类实现单例模式
    private static class TeacherContainer {
        private static Teacher teacher = new Teacher();
    }

    public static Teacher getTeacher4() {
        return TeacherContainer.teacher;
    }

    @Test
    public void test() {
        // 创建多线程检测
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(getTeacher1());
                }
            }).run();
        }
    }

}

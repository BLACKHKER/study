package com.blackhker.study.javaee.designpatterns.singleton;

/**
 * @Author BLACKHKER
 * @Date 2023/4/18 16:51
 * @ClassName: Student
 * @Description: 单例模式，饿汉式
 * @Version 1.0
 */
public class Student {

    // 私有静态成员变量，饿汉式在类加载时(程序启动时)就创建
    private static Student student = new Student();

    // 私有化构造方法
    private Student() {
    }

    // 获取单例对象实例的方法，必须是static，如果方法没有声明为静态方法，则它必须使用对象实例进行访问
    public static Student getStudent() {
        return student;
    }
}

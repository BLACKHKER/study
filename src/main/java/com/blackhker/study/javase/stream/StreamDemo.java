package com.blackhker.study.javase.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {

        /**创建流*/
        // 写法一
        Stream<Integer> intsStream = Stream.of(3, 2, 1, 1, 2, 6);

        // 写法二
        int[] nums = {1, 2, 3};
        IntStream intStream = Arrays.stream(nums);

        /**关闭流*/

//        intsStream.close();
//        intStream.close();

        /**统计流个数*/
//        Long count = intsStream.count();
//        System.out.println("流intsStream的个数是" + count);

        /**遍历流*/
        /**Lambda*/
//        intsStream.forEach((e) -> {
//            System.out.println(e);
//        });
        /**方法引用*/
//        intsStream.forEach(System.out::println);


        /**去重后遍历*/
//        intsStream.distinct().forEach(System.out::println);

        /**去重后排序再遍历*/
//        intsStream.distinct().sorted((o1, o2) -> o2 - o1).forEach(System.out::println);

        // 学生对象排序
//        Stream.of(new Student(13, "刘备"), new Student(23, "关羽"), new Student(33, "张飞"))
//                .sorted((o1, o2) -> o2.age - o1.age).forEach((stu) -> {
//                    System.out.println(stu.name);
//                });

        /**截取流*/
        intsStream.limit(3).forEach(System.out::println);

        /**过滤流*/
//        intsStream.filter((num) -> {
//            return num > 5;
//        }).forEach(System.out::println);

//        Long count = intsStream.filter((num) -> num > 5).count();
//        System.out.println(count);    // 输出1

        /**统计流的和、平均值*/
//        int sum = intsStream.mapToInt((Integer e) -> {
//            return e;
//        }).sum();
//        System.out.println(sum);

        // 简写
//        int sum = intsStream.mapToInt(e -> e).sum();

//        double average = intsStream.mapToInt((Integer e) -> {
//            return e;
//        }).average().getAsDouble();
//        System.out.println(average);

        // 简写
//        double average = intsStream.mapToInt((e) -> e).average().getAsDouble();

        /**遍历学生对象集合的姓名，转换成集合*/
//        List<String> names = Stream.of(new Student(13, "刘备"), new Student(23, "关羽"), new Student(33, "张飞"))
//                .map((Student e) -> {
//                    return e.name;
//                }).collect(Collectors.toList());
//        names.forEach(System.out::println);

//        List<String> names = Stream.of(new Student(13, "刘备"), new Student(23, "关羽"), new Student(33, "张飞"))
//                .map(Student::getName).collect(Collectors.toList());
//        names.forEach(e -> System.out.println(e));


    }
}

/**
 * 内部类
 */
class Student {

    int age;

    String name;

    public Student() {
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

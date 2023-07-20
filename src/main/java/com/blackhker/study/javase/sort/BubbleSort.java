package com.blackhker.study.javase.sort;

import java.util.Arrays;

/**
 * @Author BLACKHKER
 * @Date 2023/7/5 15:39
 * @ClassName: BubbleSort
 * @Description: 冒泡排序
 * @Version 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {

        int[] nums = {18, 3, 2, 51, 4, 73, 9, 23, 41, 423, 53, 123};    // 初始化数组
        int arraySize = nums.length - 1;    // 轮数(数组大小-1)
        int temp = 0;   // 交换数组元素时临时存储元素

        // 外层循环控制轮数
        for (int i = 0; i < arraySize; i++) {
            // 内层循环控制每轮遍历数据排序一遍
            for (int j = 0; j < arraySize - i; j++) {
                // 比较大小，升序，如果数组当前元素大于它的下一个元素，交换两个元素的位置
                if (nums[j] > nums[j + 1]) {
                    // 保存当前元素的副本
                    temp = nums[j];
                    // 用下一个元素(nums[i + 1])覆盖掉当前元素
                    nums[j] = nums[j + 1];
                    // 修改下一个元素的值为副本(nums[i])的值
                    nums[j + 1] = temp;
                }
            }
        }

        System.out.println("数组大小：" + nums.length);

        // 遍历
        Arrays.stream(nums).forEach(System.out::println);
    }
}

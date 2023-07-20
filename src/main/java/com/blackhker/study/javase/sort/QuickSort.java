package com.blackhker.study.javase.sort;

/**
 * @Author BLACKHKER
 * @Date 2023/7/19 20:15
 * @ClassName: QuickSorta
 * @Description: TODO
 * @Version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {

        int[] nums = {18, 3, 2, 51, 4, 73, 9, 23, 41, 423, 53, 123};    // 初始化数组

        // 调用快排方法
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * @param nums  排序的数组
     * @param left  左指针
     * @param right 右指针
     */
    public static void quickSort(int[] nums, int left, int right) {

        // 左指针小于右指针，递归结束
        if (left < right) {
            int partitionIndex = partition(nums, left, right); // 获取分区点
            quickSort(nums, left, partitionIndex - 1); // 对左边进行快排
            quickSort(nums, partitionIndex + 1, right); // 对右边进行快排
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[left]; // 以第一个元素为基准值
        int i = left + 1; // 左指针
        int j = right; // 右指针

        while (i <= j) { // 左右指针相遇，分区结束
            if (nums[i] < pivot) { // 左指针元素小于基准值，左指针右移
                i++;
            } else if (nums[j] >= pivot) { // 右指针元素大于等于基准值，右指针左移
                j--;
            } else { // 左右指针元素分别大于等于和小于基准值，交换元素
                swap(nums, i, j);
            }
        }

        swap(nums, left, j); // 将基准值放到分区点
        return j; // 返回分区点
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

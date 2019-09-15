package com.cc.study.datastructure.sort;

import java.util.Arrays;

/**
 * 快速排序算法
 *
 * @author chenc
 * @create 2019-09-15 14:25
 **/
public class QuickSort {

    public static void main(String[] args) {
        // 1.给出无序数组
        int[] arry = {72, 6, 57, 88, 60, 42, 83, 73, 48, 85};

        // 2.输出无序数组
        System.out.println(Arrays.toString(arry));

        // 3.快速排序
        quickSort(arry);

        // 4.输出排序后数组
        System.out.println(Arrays.toString(arry));

    }

    public static void quickSort(int[] arry) {
        int low = 0;
        int high = arry.length - 1;
        quickSort(arry, low, high);
    }

    private static void quickSort(int[] arry, int low, int high) {
        if (low >= high) {
            return;
        }
        // 分区操作，将一个数组分成两个分区，返回分区界限索引
        int index = partition(arry, low, high);

        // 对左分区进行快速排序
        quickSort(arry, low, index - 1);

        // 对右分区进行快速排序
        quickSort(arry, index + 1, high);

    }

    private static int partition(int[] arry, int low, int high) {
        // 指定左指针和右指针
        int i = low;
        int j = high;

        // 确定基准数：默认数组第一个
        //int baseIndex = low;
        int x = arry[low];

        // 使用循环进行分区操作
        while (i < j) {
            // 1.从右向左移动指针j，找到第一个小于基准值得数arry[j]
            while (arry[j] >= x && i < j) {
                j--;
            }

            // 2.将右侧找到的数放入左边的坑中，左指针向中间移动一位i++
            if (i < j) {
                arry[i] = arry[j];
                i++;
            }

            // 3.从左向右移动指针i，找到第一个大于基准值得数arry[j]
            while (arry[i] < x && i < j) {
                i++;
            }

            // 4.将左侧找到的数放入右边的坑中，右指针向中间移动一位j--
            if (i < j) {
                arry[j] = arry[i];
                j--;
            }
        }

        // 使用基准值填坑
        arry[i] = x;

        return i;
    }
}

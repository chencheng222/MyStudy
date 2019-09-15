package com.cc.study.datastructure.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author chenc
 * @create 2019-09-15 16:06
 **/
public class BubbleSort {
    public static void main(String[] args) {
        // 1.给出无序数组
        int[] arry = {72, 6, 57, 88, 60, 42, 83, 73, 48, 85};

        // 2.输出无序数组
        System.out.println(Arrays.toString(arry));

        // 3.冒泡排序
        bubbleSort(arry);

        // 4.输出排序后数组
        System.out.println(Arrays.toString(arry));

    }

    private static void bubbleSort(int[] arry) {
        if (arry == null || arry.length < 2) {
            return;
        }

        int temp;
        for (int i = 0; i < arry.length - 1; i++) {
            for (int j = 0; j < arry.length - i -1; j++) {
                if (arry[j] > arry[j + 1]) {
                    temp = arry[j];
                    arry[j] = arry[j + 1];
                    arry[j + 1] = temp;
                }
            }

        }
    }
}

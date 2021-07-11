package com.example.demo.algorithm;

import java.util.Arrays;

/**
 * @ClassName Sort
 * @Descriptino
 * @Author myzhen
 * @Date 2021/7/3 下午7:56
 * @Version 1.0
 **/
public class Sort {

    public static void main(String[] args) {
        int[] array = {4,3,9,2,1,5,8,5,7};
//        int[] ints = bubbleSort(array);
        int[] ints = quickSort(array,0,array.length-1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    // 冒泡排序
    public static int[] bubbleSort(int[] array) {
        int[] arr = Arrays.copyOf(array, array.length);
        for(int i = 0; i < arr.length -1; i++) {
            boolean flag = true;
            for(int j = 0; j < arr.length-1-i;j++){
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }

    public static int[] quickSort(int[] nums, int left ,int right) {
         if(left >= right) {
             return nums;
         }
         int i = left - 1, j = right + 1, x = nums[left];
         while (i < j) {
             while (nums[++i] < x);
             while (nums[--j] > x);
             if (i < j) {
                 int tmp = nums[i];
                 nums[i] = nums[j];
                 nums[j] = tmp;
             }
         }
         quickSort(nums,left,j);
         quickSort(nums,j+1, right);
         return nums;

//        if (left >= right){
//            return nums;
//        }
//        int i = left-1, j = right+1, x = nums[left];
//        while (i < j) {
//            while (nums[++i] < x);
//            while (nums[--j] > x);
//            if (i < j) {
//                int tmp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = tmp;
//            }
//        }
//        quickSort(nums,left,j);
//        quickSort(nums,j+1, right);
//        return nums;
    }
}

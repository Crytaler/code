package com.example.demo.algorithm;

/**
 * @ClassName Bit
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2021/7/4 下午7:31
 * @Version 1.0
 **/
public class Bit {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(1));
        int[] nums = {2, 2, 1,4,1};
        int i = singleNumber(nums);
        System.out.println(i);
    }

    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}

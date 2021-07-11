package com.example.demo.algorithm;

/**
 * @ClassName Dynamic
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2021/6/27 下午7:59
 * @Version 1.0
 **/
public class Dynamic {

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
//        int i1 = climbStair(5);
//        int i = maxSubArray(nums);
        int i = maxProfit(nums);
        System.out.println(i);
    }

    // 最大子序和
    public static int maxSubArray(int[] nums) {
        int maxAnx = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if (nums[i-1] > 0) {
                nums[i] += nums[i-1];
            }
            maxAnx = Math.max(nums[i],maxAnx);
        }
        return maxAnx;
    }

    // 爬梯子
    public static int climbStair(int n) {
        if (n <= 2) {
            return n;
        }
        int a = 1, b = 2, sum = 0;
        for(int i= 3; i <=n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    // 买卖股票最佳时机
    public static int maxProfit(int[] nums) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] < minPrice) {
                minPrice = nums[i];
            }else if (nums[i] - minPrice > maxProfit) {
                maxProfit = nums[i] - minPrice;
            }
        }
        return maxProfit;
    }
}

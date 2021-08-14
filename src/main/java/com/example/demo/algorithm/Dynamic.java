package com.example.demo.algorithm;

import java.util.Arrays;

/**
 * @ClassName Dynamic
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2021/6/27 下午7:59
 * @Version 1.0
 **/
public class Dynamic {

    public static void main(String[] args) {
        int[] nums = {0};
//        int i1 = climbStair(5);
//        int i = maxSubArray(nums);
//        int i = maxProfit(nums);
//        int i = trap(nums);
        int i = lengthOfLIS(nums);
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
    //
    // height = [0,1,0,2,1,0,1,3,2,1,2,1]
    public static int trap(int[] height) {
        int sum = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1],height[i - 1]);
        }
        for (int i = height.length - 2 ; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1],height[i + 1]);

        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(maxLeft[i],maxRight[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    public static int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

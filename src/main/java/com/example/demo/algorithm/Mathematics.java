package com.example.demo.algorithm;

/**
 * @ClassName Mathematics
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2021/7/17 下午4:53
 * @Version 1.0
 **/
public class Mathematics {

    public static void main(String[] args) {
        int[] nums = {9,9,9};
        int[] ints = plusOne(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n -1  ; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[n+1];
        digits[0] = 1;
        return digits;
    }

    // 1234567
    public static int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}

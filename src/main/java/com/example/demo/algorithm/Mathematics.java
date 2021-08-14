package com.example.demo.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Mathematics
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2021/7/17 下午4:53
 * @Version 1.0
 **/
public class Mathematics {

    public static void main(String[] args) {
        String str1 = "11";
        String str2 = "123";
        String s = addString(str1, str2);
        System.out.println(s);
//        int xxvii = romanToInt("XIV");
//        System.out.println(xxvii);
//        int i = mySqrt(9);
//        System.out.println(i);
//        int[] nums = {9,9,9};
//        int[] ints = plusOne(nums);
//        for (int i = 0; i < ints.length; i++) {
//            System.out.println(ints[i]);
//        }
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
        int left = 0, right = x, res = -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if ((long)mid * mid <= x){
                res = mid;
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return res;
    }

    static Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};
    // XXVII  XIV
    public  static int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }

    // 字符串相加
    public static String addString(String num1,String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            sb.append(tmp % 10);
            i--; j --;
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}

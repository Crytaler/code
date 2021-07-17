package com.example.demo.algorithm;

import java.util.Arrays;

public class Stringtest {
    public static void main(String[] args) {
        String[] arr = {"flower","flow","flight"};
        String s = longestCommonPrefix(arr);
        System.out.println(s);
//        String a = "ABSIB T";
//        char[] chars = a.toCharArray();
//        char[] chars1 = reverseString(chars);
//        System.out.println(Arrays.toString(chars1));

//        int i = lengthOfLastWord(a);
//        System.out.println(i);
    }

    public static char[] reverseString(char[] a) {
        int n = a.length;
        int right = n - 1;
        for (int left = 0; left < right; left++) {
            char tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
            --right;
        }
        return a;
    }

    public static int lengthOfLastWord(String s) {
        int end = s.length()-1;
        while (end >= 0 && s.charAt(end) ==' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (start >= 0 && s.charAt(start)!= ' ') {
            start--;
        }
        return end-start;
    }

    // 最长公共前缀不可以长过最短的那个字符串
    // strs = ["flower","flow","flight"]
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String first = strs[0];
        int count = strs.length;
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return first.substring(0,i);
                }
            }
        }
        return strs[0];
    }
}

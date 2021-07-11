package com.example.demo.algorithm;

import java.util.Arrays;

public class Stringtest {
    public static void main(String[] args) {
        String a = "ABSIB T";
//        char[] chars = a.toCharArray();
//        char[] chars1 = reverseString(chars);
//        System.out.println(Arrays.toString(chars1));

        int i = lengthOfLastWord(a);
        System.out.println(i);
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
}

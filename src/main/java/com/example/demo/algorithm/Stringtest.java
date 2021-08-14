package com.example.demo.algorithm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Stringtest {
    public static void main(String[] args) {
        String s = "We are happy";
        String s1 = replaceSpace(s);
        System.out.println(s1);
//        String[] arr = {"flower","flow","flight"};
//        String s = longestCommonPrefix(arr);
//        System.out.println(s);
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
    public static String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        return new String(array, 0, size);
    }

    public static String reverseLeftWords(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for(int i = n ;i < s.length(); i++){
            builder.append(s.charAt(i));
        }
        for(int i = 0 ;i < n; i++){
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> d = new ArrayDeque<String>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }

}

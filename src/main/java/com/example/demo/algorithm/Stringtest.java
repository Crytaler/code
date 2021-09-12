package com.example.demo.algorithm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Stringtest {
    public static void main(String[] args) {
//        String s = "We are happy";
//        String s1 = replaceSpace(s);
//        int i = myAto("-2147483647");
//        System.out.println(i);
        String s = reverseWordsIII("Let's take LeetCode contest");
        System.out.println(s);
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

    public static   String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int strLen = s.length(), left = 0, right = 0, len = 1, maxStart = 0, maxLen = 0;

        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }

    public static int myAto(String str) {
        int len = str.length();
        int index = 0;
        while (index < len && str.charAt(index) == ' ') {
            index++;
        }
        if (index == len) {
            return 0;
        }
        int sign = 1;
        if (str.charAt(index) == '+') {
            index++;
        }else if (str.charAt(index) == '-') {
            index++;
            sign = -1;
        }
        int res = 0;
        while (index < len) {
            char c = str.charAt(index);
            if (c < '0' || c > '9') {
                break;
            }

            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (c - '0') > Integer.MAX_VALUE % 10) ) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && (c - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + sign * (c - '0');
            index++;
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while(left < right) {
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if(left < right) {
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }

    public String reverseWordsIII(String s) {
        int len = s.length();
        int i = 0;
        char[] charArray = s.toCharArray();
        while(i < len) {
            int start = i;
            while(i < len && s.charAt(i) != ' ') {
                i++;
            }
            int left = start, right = i - 1;
            while(left < right) {
                char tmp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = tmp;
                left++;
                right--;
            }
            while(i < len && s.charAt(i) == ' ') {
                i++;
            }
        }
        return new String(charArray,0,len);
    }
}

package com.example.demo.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SlidingWindow
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2021/7/11 下午4:01
 * @Version 1.0
 **/
public class SlidingWindow {

    public static void main(String[] args) {
        String s = "tmmzuxt";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }


    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = -1, res = 0;
        for(int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(start,map.get(s.charAt(i)));
            }
            map.put(s.charAt(i),i);
            res = Math.max(res,i - start);
        }
        return res;
    }
}

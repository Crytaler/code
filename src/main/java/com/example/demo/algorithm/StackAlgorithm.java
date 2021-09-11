package com.example.demo.algorithm;

import java.util.*;

/**
 * @ClassName StackAlgorithm
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2021/7/10 下午8:16
 * @Version 1.0
 **/
public class StackAlgorithm {

    public static void main(String[] args) {
        Boolean valid = isValid("(]");
        System.out.println(valid);
    }

    public static Boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character,Character> map = new HashMap<>(4);
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        Deque<Character> stack = new LinkedList<>();
        for(int i =0 ; i < n; i++) {
            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != map.get(s.charAt(i))) {
                    return false;
                }else {
                    stack.pop();
                }
            }else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static Boolean isMatch(char left, char right) {
        switch(right) {
            case ')':
                return left == '(';
            case '}':
                return left == '{';
            case ']':
                return left == '[';
            default:
                return false;
        }
    }


    public int longestValidParentheses(String s) {
        int maxAnx = 0;
        int len;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                }else{
                    len = i - stack.peek();
                    maxAnx = Math.max(len, maxAnx);
                }
            }
        }
        return maxAnx;
    }
}

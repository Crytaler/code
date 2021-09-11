package com.example.demo.algorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @ClassName StackAlgo
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2021/8/14 下午3:57
 * @Version 1.0
 **/
public class StackAlgo {

    static class MinStack {
        private Deque<Integer> data;
        private Deque<Integer> min;

        public MinStack() {
            data = new LinkedList<Integer>();
            min = new LinkedList<Integer>();
            min.push(Integer.MAX_VALUE);
        }
        public void push(int val) {
            data.push(val);
            min.push(Math.min(min.peek(),val));
        }
        public void pop() {
            data.pop();
            min.pop();
        }
        public int top() {
            return data.peek();
        }
        public int getMin() {
            return min.peek();
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}

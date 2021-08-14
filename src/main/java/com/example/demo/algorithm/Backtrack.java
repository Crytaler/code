package com.example.demo.algorithm;

import java.util.*;

/**
 * @ClassName Backtrack
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2021/7/25 下午6:15
 * @Version 1.0
 **/
public class Backtrack {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = subsets(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums,len,0,path,used,res);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if(used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums,len,depth+1,path,used,res);
            path.removeLast();
            used[i] = false;
        }
    }
    public static List<List<Integer>> subsets(int[] nums){
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        dfs(nums,len,0,res,path);
        return res;
    }
    // 123
    public static void dfs(int[] nums,int len, int depth,List<List<Integer>> res,Deque<Integer> path) {
        res.add(new ArrayList<>(path));
        for(int i = depth; i < len; i++) {
            path.addLast(nums[i]);
            dfs(nums,len,i + 1,res,path);
            path.removeLast();
        }
    }

}

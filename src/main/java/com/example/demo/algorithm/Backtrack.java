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
        List<String> strings = restoreIpAddresses("0000");
        for (String string : strings) {
            System.out.println(string);
        }
//        int[] nums = {1, 2, 3};
//        List<List<Integer>> lists = subsets(nums);
//        System.out.println(lists);
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

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }
    public void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path ,List<List<Integer>> res) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        /** 重点理解这里从 begin 开始搜索的语意 */
        for(int i = begin; i < len; i++) {
            path.addLast(candidates[i]);
            /** 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错 */
            dfs(candidates, i, len, target - candidates[i], path, res);

            path.removeLast();
        }
    }


    public static List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if(len < 4 || len > 12) {
            return res;
        }
        Deque<String> path = new ArrayDeque<>();
        int splitTimes = 0;
        dfs(s, 0, len, splitTimes,  path, res);
        return res;
    }

    public static void dfs(String s, int begin, int len, int times, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (times == 4) {
                res.add(String.join(".",path));
            }
            return;
        }
        if (len - begin < (4 - times) || len - begin > 3 * (4 - times)) {
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (begin + i >= len) {
                break;
            }
            int ip = judgeIfIpSegment(s, begin, begin + i);
            if(ip != -1) {
                path.addLast(ip + "");
                dfs(s,begin+i+1,len,times+1,path,res);
                path.removeLast();
            }

        }
    }

    public static int judgeIfIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return -1;
        }

        int res = 0;
        for(int i = left; i <= right; i++) {
            res = res * 10 +s.charAt(i) - '0';
        }
        if (res > 255) {
            return -1;
        }
        return res;
    }

    // n是括号对数，lc是左括号数量，rc是右括号数量，str是当前维护的合法括号序列。
    //
    //搜索过程如下：
    //
    //1、初始时定义序列的左括号数量lc 和右括号数量rc都为0。
    //2、如果 lc < n，左括号的个数小于n，则在当前序列str后拼接左括号。
    //3、如果 rc < n && lc > rc , 右括号的个数小于左括号的个数，则在当前序列str后拼接右括号。
    //4、当lc == n && rc == n 时，将当前合法序列str加入答案数组res中。

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n == 0) {
            return res;
        }
        dfs(n,0,0,"");
        return res;
    }

    public void dfs(int n, int lc, int rc, String str) {
        if(lc == n && rc == n) {
            res.add(str);
        }else {
            if(lc < n) {
                dfs(n, lc+1, rc, str+"(");
            }
            if(rc < n && rc < lc) {
                dfs(n,lc, rc+1, str+")");
            }
        }

    }



}

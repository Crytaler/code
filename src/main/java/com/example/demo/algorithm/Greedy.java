package com.example.demo.algorithm;

/**
 * @ClassName Greedy
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2021/9/12 下午2:39
 * @Version 1.0
 **/
public class Greedy {


    // "(*))" 最小值是为了防止左括号溢出的，为零代表没有溢出，为正代表有n个左括号等待匹配，
    // 我们只需要了解在当前坐标后面，是否能够匹配这n个左括号。因为左括号不能与他前面的右括号或者星号匹配，所以负值没有意义，最小值不可以为负数。
    public boolean checkValidString(String s) {
        int minCount = 0, maxCount = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '(') {
                minCount++;
                maxCount++;
            }else if (c == ')') {
                minCount = Math.max(minCount-1,0);
                maxCount--;
                if(maxCount < 0) {
                    return false;
                }
            }else {
                minCount = Math.max(minCount-1,0);
                maxCount++;
            }
        }
        return minCount == 0;
    }
}

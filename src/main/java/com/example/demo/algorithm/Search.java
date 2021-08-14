package com.example.demo.algorithm;

/**
 * @ClassName Search
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2021/7/24 下午8:49
 * @Version 1.0
 **/
public class Search {

    public  static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target) {
                l = mid + 1;
            }else if (nums[mid] > target) {
                r = mid - 1;
            }
        }
        return -1;
    }
}

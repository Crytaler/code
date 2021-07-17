package com.example.demo.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Array
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2021/6/27 下午4:10
 * @Version 1.0
 **/
public class Array {

    public static void main(String[] args) {

        int[] num1 = {1,2,3,8,9,9};
        int[] ints = sortArrayByParity(num1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
//        Boolean aBoolean = containDup(num1);
//        System.out.println(aBoolean);
//        int i = removeDuplicates(num1);
//        int[] merge = twoSum(num1, 5);
//        int[] num2 = {2,5,6};
//        int[] merge = merge(num1, 3, num2, 3);
//        for (int i1 : merge) {
//            System.out.println(i1);
//        }

//        int i = removeElement(num1, 9);
//        System.out.println(i);

    }

    public static int[] twoSum(int[] array, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < array.length;i++) {
            int result = target - array[i];
            if (map.containsKey(result)) {
                return new int[]{map.get(result),i};
            }
            map.put(array[i],i);
        }
        return null;
    }

    // 删除数组重复项 并返回数组长度
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast-1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m+n];
        int cur;
        while (p1 < m || p2 < n) {
           if (p1 == m) {
               cur = nums2[p2++];
           }else if (p1 == n) {
               cur =nums1[p1++];
           }else if (nums1[p1] < nums2[p2]) {
               cur = nums1[p1++];
           }else {
               cur = nums2[p2++];
           }
            sorted[p1+p2-1] = cur;
        }
        return sorted;
    }

    public static Boolean hasCircle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right-1];
                right--;
            }else {
                left++;
            }
        }
        return left;
    }

    public static Boolean containDup(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int num : arr) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    // 如果是 (0, 1)，那么万事大吉 i++ 并且 j--。
    //如果是 (1, 0)，那么交换两个元素，然后继续。
    //如果是 (0, 0)，那么说明 i 位置是正确的，只能 i++。
    //如果是 (1, 1)，那么说明 j 位置是正确的，只能 j--。
    public static int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length-1;
        while (i < j) {
            if (nums[i] % 2 > nums[j] % 2) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            if (nums[i] % 2 == 0){
                i++;
            }
            if (nums[j] % 2 == 1) {
                j--;
            }
        }
        return nums;
    }
}

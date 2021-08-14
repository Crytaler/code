package com.example.demo.algorithm;

import java.util.*;

/**
 * @ClassName Array
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2021/6/27 下午4:10
 * @Version 1.0
 **/
public class Array {

    public static void main(String[] args) {

        int[] num1 = {4,5,6,7,0,1,2};
        int search = search(num1, 0);
        System.out.println(search);
//        int[] ints = twoSum2(num1,9);
//        int[] ints = sortArrayByParity(num1);
//        List<List<Integer>> lists = threeSum(num1);
//        for (List<Integer> list : lists) {
//            System.out.println(list);
//        }
//        int[] ints = moveZeroes(num1);
//        for (int anInt : ints) {
//            System.out.println(anInt);
//        }
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

    // 2,7,8,11,15 -->10
//    public static int[] twoSum2(int[] numbers, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < numbers.length; i++) {
//            int result = target - numbers[i];
//            if (map.containsKey(result)) {
//                return new int[]{++i,map.get(result)+1};
//            }
//            map.put(numbers[i],i);
//        }
//        return null;
//    }

    public static int[] twoSum2(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left+1,right+1};
            }else if (sum > target) {
                --right;
            }else {
                ++left;
            }
        }
        return new int[]{-1,-1};
    }

    // 输入: [0,1,0,3,12]
    // 输出: [1,3,12,0,0]
    public static int[] moveZeroes(int[] nums){
        int left = 0, right = 0, n = nums.length;
        while(right < n) {
            if(nums[right] != 0) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
            }
            right++;
        }
        return nums;
    }

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3){
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1, R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L < R && nums[L] == nums[L+1]){
                        L++;
                    };
                    while (L < R && nums[R] == nums[R-1]){
                        R--;
                    };
                    L++;
                    R--;
                }else if (sum < 0){
                    L++;
                }else if (sum > 0){
                    R--;
                }
            }
        }
        return res;
    }


    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1, mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序,注意此处用小于等于
            if (nums[start] <= nums[mid]) {
                //target在前半部分
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for (int num : set) {
            res[index++] = num;
        }
        return res;
    }
}

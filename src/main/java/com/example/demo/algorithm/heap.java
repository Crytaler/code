package com.example.demo.algorithm;

import java.util.PriorityQueue;

/**
 * @ClassName heap
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2021/7/10 下午5:37
 * @Version 1.0
 **/
public class heap {

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,6,7,4};
        int largest = findKthLargest(arr, 2);
        System.out.println(largest);
//        int[] leastNumbers = getLeastNumbers(arr, 1);
//        for (int leastNumber : leastNumbers) {
//            System.out.println(leastNumber);
//        };
    }

    public static void heap() {
        int[] c = {2,17,4,12,8,21,15,33};
        //可以直接使用lamda表达式实现个人觉得这个方式比较好
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        //2，通过比较器排序，实现最大堆
/*		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
		    //   以下是对比较器升序、降序的理解.
			//	 (1) 写成return a.compareTo(b) 或者 return a-b表示升序(最小堆)
			//	 (2) 写成return b.compareTo(a) 或者 return b-a表示降序(最大堆)
				return b.compareTo(a);
			}

		}) ;
*/
        for (int i : c) {
            pq.offer(i);
        }
        System.out.println(pq);

        System.out.println(pq.peek());
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] vars = new int[k];
        if (k == 0) {
            return vars;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i = 0 ; i < k; i++) {
            pq.offer(arr[i]);
        }
        for(int i = k; i < arr.length; i++) {
            if(pq.peek() > arr[i]) {
                pq.poll();
                pq.offer(arr[i]);
            }
        }
        for(int i = 0 ; i < k; i++) {
            vars[i] = pq.poll();
        }
        return vars;
    }

    public static int findKthLargest(int[] nums,int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < k; i++) {
            pq.offer(nums[i]);
        }
        for(int i = k ; i < nums.length; i++) {
            if (pq.peek() < nums[i]) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }
}

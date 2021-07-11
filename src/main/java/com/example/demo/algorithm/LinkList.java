package com.example.demo.algorithm;


import java.util.*;

/**
 * @ClassName testAlgorithm
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2021/6/26 下午8:24
 * @Version 1.0
 **/
public class LinkList {
    public static void main(String[] args) {
        ListNode head1 = initLink();
        ListNode head2 = initLinkSecond();

        ListNode listNode = swapPairs(head1);

//        boolean palindrome = isPalindrome(head1);
//        System.out.println(palindrome);
//        int sum=getSum(4);              //调用递归方法,获得1~4的和
//        System.out.println("sum="+sum);  //打印结果

//        ListNode listNode = reverseList(head1);
//        ListNode listNode = mergeList(head1, head2);
//        ListNode listNode = removeNthFromEnd(head1, 3);
//        ListNode listNode = getIntersectionNode(a, a1);
//        ListNode listNode = addTwoNumbers(head1, head2);
//        ListNode listNode = deleteDuplicates(head1);
//        ListNode listNode = swapPairs(head1);
//        Boolean aBoolean = hasCircle(head1);
//        System.out.println(aBoolean);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static int getSum(int n) {
        if(n==1){
            //满足条件,递归结束
            return 1;
        }
        int temp=getSum(n-1);
        return temp+n;
    }


    public static ListNode initLink() {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        return a;
    }

    public static ListNode initLinkSecond() {
        ListNode a1 = new ListNode(5);
        ListNode b1 = new ListNode(6);
        ListNode c1 = new ListNode(7);
        ListNode d1 = new ListNode(10);
        ListNode e1 = new ListNode(24);
        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        d1.next = e1;
        return a1;
    }



    // 两数之和
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = l1, q = l2, cur = dummy;
        int carry = 0;
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = carry + x + y;
            carry = sum/10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) {p = p.next;}
            if (q != null) {q = q.next;}
        }
        return dummy.next;
    }
    // 删除链表重复节点
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
//        if (head == null || head.next == null) {
//            return head;
//        }
//        head.next = deleteDuplicates(head.next);
//        return head.val == head.next.val ? head.next : head;
    }
    // 节点两两交换
    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode tmp = dummyHead;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode node1 = tmp.next;
            ListNode node2 = tmp.next.next;
            tmp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            tmp = node1;
        }
        return dummyHead.next;
    }
    // 反转链表
    public static ListNode reverseList(ListNode head){
        ListNode next = null;
        ListNode pre =null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    // 合并两个有序链表
    public static ListNode mergeList(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeList(list1.next,list2);
            return list1;
        }else {
            list2.next = mergeList(list1,list2.next);
            return list2;
        }
    }
    // 删除链表岛素第n个节点 & 找出链表倒数第k个节点
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node1 = dummy, node2 = dummy;
        while (node1 != null) {
            node1 = node1.next;
            if (n < 1 && node1 != null) {
                node2 = node2.next;
            }
            n--;
        }
        node2.next = node2.next.next;
        return dummy.next;
    }
    // 链表交点
    public  static ListNode getIntersectionNode (ListNode head1, ListNode head2) {
        ListNode l1 = head1, l2 = head2;
        while (l1 != l2) {
            l1 = l1 == null ? head2 :l1.next;
            l2 = l2 == null ? head1 :l2.next;
        }
        return l1;
    }
    // 链表是否环
    public static Boolean  hasCircle(ListNode head) {
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

    public static boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        int left = 0;
        int right = vals.size()-1;
        while (left < right) {
            if (!Objects.equals(vals.get(left),vals.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}

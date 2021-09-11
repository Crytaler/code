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
        ListNode head = initLink();
        ListNode head1 = initLink1();
        ListNode head2 = initLink2();
        ListNode[] lists = new ListNode[]{head,head1,head2};
        ListNode listNode = mergeKLists(lists);
//        int[] ints = reversePrint(head1);
//        ListNode listNode = reverseKGroup(head1, 2);
//        for (int anInt : ints) {
//            System.out.println(anInt);
//        }
//        ListNode head2 = initLinkSecond();
//
//        ListNode listNode = swapPairs(head1);

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
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
//        ListNode d = new ListNode(5);
//        ListNode e = new ListNode(6);
        a.next = b;
        b.next = c;
//        c.next = d;
//        d.next = e;
        return a;
    }

    public static ListNode initLink1() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(5);
//        ListNode d = new ListNode(5);
//        ListNode e = new ListNode(6);
        a.next = b;
        b.next = c;
//        c.next = d;
//        d.next = e;
        return a;
    }

    public static ListNode initLink2() {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(6);
        ListNode c = new ListNode(4);
//        ListNode d = new ListNode(5);
//        ListNode e = new ListNode(6);
        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
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

    public static int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new LinkedList<Integer>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] nums = new int[stack.size()];
        int size = stack.size();
        for(int i =0; i < size; i++){
            nums[i] = stack.pop();
        }
        return nums;
    }

    public static ListNode reverseKGroup(ListNode head, int k){
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        //初始化pre和end都指向dummy。pre指每次要翻转的链表的头结点的上一个节点。end指每次要翻转的链表的尾节点
        ListNode pre=dummy;
        ListNode end=dummy;
        while(end.next!=null){
            //循环k次，找到需要翻转的链表的结尾,这里每次循环要判断end是否等于空,因为如果为空，end.next会报空指针异常。
            //dummy->1->2->3->4->5 若k为2，循环2次，end指向2
            for(int i=0;i<k&&end != null;i++){
                end=end.next;
            }
            //如果end==null，即需要翻转的链表的节点数小于k，不执行翻转。
            if(end==null){
                break;
            }
            //先记录下end.next,方便后面链接链表
            ListNode next=end.next;
            //然后断开链表
            end.next=null;
            //记录下要翻转链表的头节点
            ListNode start=pre.next;
            //翻转链表,pre.next指向翻转后的链表。1->2 变成2->1。 dummy->2->1
            pre.next=reverse(start);
            //翻转后头节点变到最后。通过.next把断开的链表重新链接。
            start.next=next;
            //将pre换成下次要翻转的链表的头结点的上一个节点。即start
            pre=start;
            //翻转结束，将end置为下次要翻转的链表的头结点的上一个节点。即start
            end=start;
        }
        return dummy.next;
    }
    public static ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static ListNode detectCycle(ListNode head){
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    // 1-3-5 1-4-6 2-6
    public static ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode node: lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = tail.next;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return dummyHead.next;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        reverse(leftNode);

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;

        for(int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode end = pre;

        for(int i = 0; i < right - left + 1; i++) {
            end = end.next;
        }

        ListNode start = pre.next;
        ListNode next = end.next;

        pre.next = null;
        end.next = null;

        reverse(start);

        pre.next = end;
        start.next = next;

        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if(head == null) {
            return head;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> a-b);
        while(head != null) {
            queue.offer(head.val);
            head = head.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while(!queue.isEmpty()) {
            Integer node = queue.poll();
            ListNode res = new ListNode(node);
            cur.next = res;
            cur = cur.next;
        }
        return dummy.next;
    }

    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        ListNode mid =  middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        merge(l1,l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void merge(ListNode l1, ListNode l2) {
        ListNode cur1 ;
        ListNode cur2 ;
        while(l1 != null && l2 != null) {
            cur1 = l1.next;
            cur2 = l2.next;

            l1.next = l2;
            l1 = cur1;

            l2.next = l1;
            l2 =cur2;
        }
    }

}

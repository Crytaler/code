package com.example.demo.algorithm;

import java.util.*;

/**
 * @ClassName Tree
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2021/7/3 下午9:16
 * @Version 1.0
 **/
public class Tree {

    public static void main(String[] args) {
        TreeNode treeNode = initTreeNode();
//        int i = maxDepth(treeNode);
//        System.out.println(i);
//        List<Integer> vals = postorderTraversal(treeNode);
        List<List<Integer>> lists = levelOrder(treeNode);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

    }

    public static  TreeNode initTreeNode() {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        return t1;
    }

    // 二叉树的最大深度
    public static int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = maxDepth(node.left);
        int rightHeight = maxDepth(node.right);
        return Math.max(leftHeight,rightHeight)+1;
    }

    // 二叉树的中序遍历
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (res == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            }else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentSize = queue.size();
            for (int i = 1; i <= currentSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }

}

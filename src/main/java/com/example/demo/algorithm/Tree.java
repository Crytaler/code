package com.example.demo.algorithm;

import org.apache.commons.compress.utils.Lists;

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
        List<List<Integer>> lists = zigzagLevelOrder(treeNode);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
//        TreeNode treeNode1 = invertTree(treeNode);
//        int i = maxDepth(treeNode);
//        System.out.println(i);
//        List<Integer> vals = postorderTraversal(treeNode);
//        List<List<Integer>> lists = levelOrder(treeNode);
//        for (List<Integer> list : lists) {
//            System.out.println(list);
//        }

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

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }else if (p == null || q == null) {
            return false;
        }else if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null) {
            return true;
        }
        //调用递归函数，比较左节点，右节点
        return dfs(root.left,root.right);
    }
    boolean dfs(TreeNode left, TreeNode right) {
        //递归的终止条件是两个节点都为空
        //或者两个节点中有一个为空
        //或者两个节点的值不相等
        if(left==null && right==null) {
            return true;
        }
        if(left==null || right==null) {
            return false;
        }
        if(left.val!=right.val) {
            return false;
        }
        //再递归的比较 左节点的左孩子 和 右节点的右孩子
        //以及比较  左节点的右孩子 和 右节点的左孩子
        return dfs(left.left,right.right) && dfs(left.right,right.left);
    }

    public static TreeNode invertTree(TreeNode root) {
        //递归函数的终止条件，节点为空时返回
        if(root==null) {
            return null;
        }
        //下面三句是将当前节点的左右子树交换
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        //递归交换当前节点的 左子树
        invertTree(root.left);
        //递归交换当前节点的 右子树
        invertTree(root.right);
        //函数返回时就表示当前这个节点，以及它的左右子树
        //都已经交换完了
        return root;
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOrderLeft = true;
        while (!queue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(cur.val);
                }else {
                    levelList.offerFirst(cur.val);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return res;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) return null; // 1.
        if(left == null) return right; // 3.
        if(right == null) return left; // 4.
        return root; // 2. if(left != null and right != null)
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) { //将当前层的最后一个节点放入结果列表
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        //分别计算左子树和右子树的高度
        int left = depth(root.left);
        int right = depth(root.right);
        //这两个子树的高度不能超过1，并且他的两个子树也必须是平衡二叉树
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    //计算树中节点的高度
    public int depth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftGain = Math.max(maxGain(node.left),0);
        int rightGain = Math.max(maxGain(node.right),0);

        int tempSum = node.val + leftGain + rightGain;
        maxSum = Math.max(tempSum,maxSum);

        return node.val + Math.max(leftGain,rightGain);
    }

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum);
        return res;
    }

    public void dfs(TreeNode root , int targetSum) {
        if(root == null) {
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if(root.left == null && root.right == null && targetSum == 0) {
            res.add(new ArrayList<>(path));
        }
        dfs(root.left,targetSum);
        dfs(root.right,targetSum);
        path.pollLast();
    }

}

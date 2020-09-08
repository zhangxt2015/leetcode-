package com.company.binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 二叉树中序遍历
public class First {
    public List<Integer> solution1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    // 辅助函数，用于递归
    // 中序遍历 左-中-右
    public void helper(TreeNode root, List<Integer> res) {
        if (root.left != null) {
            helper(root.left, res);
        }
        res.add(root.val);
        if (root.right != null) {
            helper(root.right, res);
        }
    }

    // 递归
//    public List<Integer> solution1Copy(TreeNode root) {
//
//    }

    // 中序 深度遍历
    public void helperCopy(TreeNode root, List<Integer> res) {
        if (root.left != null) {
            helperCopy(root.left, res);
        }

        //【中】
        res.add(root.val);

        if (root.right != null) {
            helperCopy(root.right, res);
        }
    }

    // 栈
    // 【依次遍历左节点放入栈中，直到尽头
    // 弹出栈顶元素，写入队列】
    // 对右节点重新开始以上循环
    public List<Integer> solution2(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            // 从根节点开始循环遍历左子树，从上到下、依次入栈
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // 取出栈顶元素，放入队列
            current = stack.pop();
            arr.add(current.val);
            // 取出当前的元素的右子树
            current = current.right;
        }
        return arr;
    }

    public List<Integer> solution2Copy(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // 遍历节点的左节点，直到尽头
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            //【中】
            // 栈顶元素没有左节点
            //取出栈顶元素，放入队列中
            current = stack.pop();
            arr.add(current.val);

            // 取出当前节点的右节点，重新开始循环遍历左节点
            current = current.right;
        }
        return arr;
    }
}

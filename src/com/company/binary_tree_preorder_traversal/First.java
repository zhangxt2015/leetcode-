package com.company.binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// 二叉树前序遍历【根-左-右】
public class First {
    // 递归
    public List<Integer> solution1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    // 递归辅助函数
    public void helper(TreeNode root, List<Integer> res) {
        res.add(root.val);

        if (root.left != null) {
            helper(root.left, res);
        }

        if (root.right != null) {
            helper(root.right, res);
        }
    }

    // 栈
    // 将当前节点写入数组
    // 依次将右-左节点写入栈，因为是前序【根-左-右】，所以入栈顺序需要相反【右-左-根】
    public List<Integer> solution2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> arr = new LinkedList<>();
        if (root == null) {
            return arr;
        }
        stack.add(root);
        if (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            arr.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }

            if (node.left != null) {
                stack.add(node.left);
            }
        }

        return arr;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }
}

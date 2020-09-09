package com.company.binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 前序遍历
public class Second {
    // 递归，借助辅助函数
    public List<Integer> solution1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, ArrayList<Integer> res) {
        if (root != null) {
            res.add(root.val);

            if (root.left != null) {
                helper(root.left, res);
            }

            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    // 栈
    public ArrayList<Integer> solution2(TreeNode root) {
        ArrayList<Integer> array = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return array;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            array.add(node.val);

            // 因为栈的先入后出特性，先push右节点，再push左节点
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return array;
    }
}

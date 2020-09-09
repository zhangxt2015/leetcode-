package com.company.binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.Stack;

//中序遍历
public class Second {
    // 递归，使用辅助函数
    public ArrayList<Integer> solution1(TreeNode root) {
        ArrayList<Integer> array = new ArrayList<>();
        helper(root, array);
        return array;
    }

    public void helper(TreeNode node, ArrayList<Integer> array) {
        if (node != null) {
            if (node.left != null) {
                helper(node.left, array);
            }

            array.add(node.val);

            if (node.right != null) {
                helper(node.right, array);
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

        while (root != null || !stack.isEmpty()) {
            // 将节点的左节点循环入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // 弹出栈顶元素（最左节点）
            root = stack.pop();
            array.add(root.val);

            root = root.right;
        }

        return array;
    }
}

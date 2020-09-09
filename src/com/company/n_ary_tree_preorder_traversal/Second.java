package com.company.n_ary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//n叉树的前序遍历【根-左-右】
public class Second {
    // 递归
    public List<Integer> solution1(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    //辅助函数
    public void helper(Node node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            for (Node n : node.children) {
                helper(n, list);
            }
        }
    }

    // 栈
    public List<Integer> solution2(Node root) {
        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);

            Collections.reverse(node.children);
            for (Node n : node.children) {
                stack.push(n);
            }
        }
        return list;
    }
}

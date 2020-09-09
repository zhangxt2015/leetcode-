package com.company.n_ary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

// 前序遍历n叉树
public class First {
    // 递归+辅助函数
    public List<Integer> solution1(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    // 辅助函数
    public void helper(Node node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);

            for (Node n : node.children) {
                helper(n, list);
            }
        }
    }

    //迭代-通过栈 【中-左-右】 => 【右-左-中】
    public List<Integer> solution2(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        // 中
        stack.push(root);
        //中-左-右
        while (!stack.isEmpty()) {
            // 经过双重循环之后，弹出的元素是按照children中从左到右的顺序
            Node node = stack.pop();
            list.add(node.val);
            //反转数组
            Collections.reverse(node.children);
            //栈-先进后出
            for (Node n : node.children) {
                stack.push(n);
            }
        }
        return list;
    }
}

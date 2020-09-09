package com.company.n_ary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//n叉树的后续遍历
public class Three {
    //递归
    public List<Integer> solution1(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public void helper(Node node, List<Integer> list) {
        if (node != null) {
            for (Node n : node.children) {
                helper(n, list);
            }
            list.add(node.val);
        }
    }

    // 栈 【左-右-根】 => 【根-右-左】
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

            // 子节点从左往右入栈，出栈之后是 子节点的顺序是 从右往左，
            for (Node n : node.children) {
                stack.push(n);
            }
        }

        Collections.reverse(list);
        return list;
    }
}

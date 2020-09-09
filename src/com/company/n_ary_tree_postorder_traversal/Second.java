package com.company.n_ary_tree_postorder_traversal;

import java.util.*;

public class Second {
    // 递归
    public List<Integer> solution1(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    // 辅助函数
    public void helper(Node node, List<Integer> list) {
        if (node != null) {
            for (Node n : node.children) {
                helper(n, list);
            }
            list.add(node.val);
        }
    }

    // 栈，后续遍历 【左-右-中】， => 【中-右-左】
    public List<Integer> solution2(Node root) {
        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        // 循环结束之后，元素按照【中-右-左】的顺序保存到list中
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            // 将中元素输入集合
            list.add(node.val);
            for (Node n : node.children) {
                //入栈的子元素在下一重循环中被从右往左取出
                stack.push(n);
            }
        }

        // 反转list
        Collections.reverse(list);
        return list;
    }
}

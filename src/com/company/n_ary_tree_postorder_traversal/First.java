package com.company.n_ary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

// 后续遍历多叉树
public class First {
    // 递归-借助辅助函数
    // n叉树的遍历规则 子节点集合->根
    public List<Integer> solution1(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public void helper(Node node, List<Integer> list) {
        if (node != null) {
            for (Node i : node.children) {
                helper(i, list);
            }
            list.add(node.val);
        }
    }

    // 栈 后续遍历是 左-右-根，反转的情况是 根-右-左
    // 先构造一个【根-右-左】的list，
    // 将children中的节点从左到右 循环入栈
    public List<Integer> solution2(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);

            //将children中的节点从左到右入栈，出栈顺序则会是 右-左
            for (Node n : node.children) {
                stack.push(n);
            }
        }

        Collections.reverse(list);
        return list;
    }
}

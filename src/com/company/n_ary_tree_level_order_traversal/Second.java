package com.company.n_ary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//n叉树的层序遍历
public class Second {
    // 输出一维数组
    // 通过队列层序遍历树
    public List<Integer> solution1(Node root) {
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            list.add(node.val);
            queue.addAll(node.children);
        }
        return list;
    }

    // 层序遍历树，输出二维数组
    public List<List<Integer>> solution2(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> sub_list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                sub_list.add(node.val);
                queue.addAll(node.children);
            }
            list.add(sub_list);
        }
        return list;
    }
}

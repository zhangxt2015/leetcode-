package com.company.n_ary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// n叉树层序遍历，输出二维数组
public class First {
    // 将层序遍历得到的一维数组转化为二维数组
    public List<List<Integer>> solution1(Node root) {
        List<List<Integer>> total_list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> out_put = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //将队列的中所有元素输出到列表中，并将对应的子元素加入到队列中
                Node node = queue.remove();
                out_put.add(node.val);
                queue.addAll(node.children);
            }
            total_list.add(out_put);
        }
        return total_list;
    }

    public List<List<Integer>> solution1Copy(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> output = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                output.add(node.val);
                queue.addAll(node.children);
            }
            list.add(output);
        }

        return list;
    }








    // 使用队列对树进行层序遍历
    public List<Integer> solution(Node root) {
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
}

package com.company.lowest_common_ancestor_of_a_binary_tree;

// 二叉树的最近公共祖先
public class First {
    private TreeNode ans;

    public TreeNode solution1(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return ans;
    }

    // 递归辅助函数
    public boolean helper(TreeNode node, TreeNode p, TreeNode q) {
        // 终结者（递归终止条件）
        if (node == null) {
            return false;
        }

        // 逻辑
        boolean lson = helper(node.left, p, q);
        boolean rson = helper(node.right, p, q);

        if ((lson && rson) || ((node.val == p.val || node.val == q.val) && (lson || rson))) {
            ans = node;
        }

        return lson || rson || (node.val == p.val || node.val == q.val);
    }
}

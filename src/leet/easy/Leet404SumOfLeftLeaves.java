package leet.easy;

import leet.util.TreeNode;

public class Leet404SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if(root == null) return res;
        if(isLeaf(root.left)) res += root.left.val;
        return res + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

}

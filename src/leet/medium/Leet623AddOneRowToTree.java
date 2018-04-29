package leet.medium;

import java.util.LinkedList;
import java.util.Queue;

import leet.util.TreeNode;

public class Leet623AddOneRowToTree {
	public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1) {
        	TreeNode res = new TreeNode(v);
        	res.left = root;
        	return res;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        int curDepth = 1;
        while(curDepth++ < d-1) {
        	while(!q1.isEmpty()) {
	        	TreeNode tmp = q1.poll();
	        	if(tmp.left != null) q2.offer(tmp.left);
	        	if(tmp.right != null) q2.offer(tmp.right);
        	}
        	Queue<TreeNode> swap = q1;
        	q1 = q2;
        	q2 = swap;
        }
        while(!q1.isEmpty()) {
        	TreeNode tmp = q1.poll();
        	TreeNode l = tmp.left, r = tmp.right;
        	tmp.left = new TreeNode(v);
        	tmp.right = new TreeNode(v);
        	tmp.left.left = l;
        	tmp.right.right = r;
        }
        return root;
    }
}

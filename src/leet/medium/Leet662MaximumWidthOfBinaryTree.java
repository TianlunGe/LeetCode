package leet.medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import leet.util.TreeNode;

public class Leet662MaximumWidthOfBinaryTree {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(9);
		Leet662MaximumWidthOfBinaryTree t = new Leet662MaximumWidthOfBinaryTree();
		t.widthOfBinaryTree(root);
	}
	
	public int widthOfBinaryTree(TreeNode root) {
		if(root == null) return 0;
    	int depth = this.maxDepth(root);
    	if(depth == 1) return 1;
    	LinkedList<TreeNode> pre = new LinkedList<>();
    	LinkedList<TreeNode> cur = new LinkedList<>();
    	pre.add(root);
        int ans = 0;
        for(int i=1; i<depth; i++) {
        	Iterator<TreeNode> it = pre.listIterator();
        	while(it.hasNext()) {
        		TreeNode node = it.next();
        		if(node != null) {
        			cur.add(node.left);
        			cur.add(node.right);
        		}
        		else {
        			cur.add(null);
        			cur.add(null);
        		}
        		it.remove();
        	}
        	ans = Math.max(ans, this.getLength(cur));
        	LinkedList<TreeNode> tmp = pre;
        	pre = cur;
        	cur = tmp;
        }
        return ans;
    }
	
	private int getLength(LinkedList<TreeNode> list) {
		while(list.peekFirst() == null) list.pollFirst();
		while(list.peekLast() == null) list.pollLast();
		return list.size();
	}

	private int maxDepth(TreeNode root) {
    	if(root == null) return 0;
    	return 1 + Math.max(this.maxDepth(root.left), this.maxDepth(root.right));
    }
    
}

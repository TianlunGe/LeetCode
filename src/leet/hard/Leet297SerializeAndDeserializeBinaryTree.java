package leet.hard;

import java.util.LinkedList;
import java.util.Queue;

import leet.util.TreeNode;

public class Leet297SerializeAndDeserializeBinaryTree {
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder pre = new StringBuilder();
        StringBuilder tai = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
        	TreeNode tmp = q.poll();
        	if(tmp == null) {
        		pre.append('0');
        	}
        	else {
        		pre.append('1');
        		tai.append(tmp.val);
        		tai.append(',');
        		q.offer(tmp.left);
        		q.offer(tmp.right);
        	}
        }
        pre.append(':');
        pre.append(tai);
        return pre.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if(data.charAt(0) == '0') return null;
        String[] ss = data.split(":");
        char[] cs = ss[0].toCharArray();
        String[] nums = ss[1].split(",");
        int cur = 0;
        TreeNode root = new TreeNode(Integer.valueOf(nums[cur++]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for(int i=1; i<cs.length; ) {
        	TreeNode tmp = q.poll();
        	if(cs[i++] == '1') {
        		tmp.left = new TreeNode(Integer.valueOf(nums[cur++]));
        		q.offer(tmp.left);
        	}
        	if(cs[i++] == '1') {
        		tmp.right = new TreeNode(Integer.valueOf(nums[cur++]));
        		q.offer(tmp.right);
        	}
        }
        return root;
    }
}

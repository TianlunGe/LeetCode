package leet.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leet.util.TreeNode;

public class Leet508MostFrequentSubtreeSum {
	
	private int maxCount = 1;
	
	public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> count = new HashMap<>();
        this.midCount(count, root);
        List<Integer> res = new ArrayList<>();
        for(int key : count.keySet()) {
        	if(count.get(key) == maxCount) res.add(key);
        }
        int[] ans = new int[res.size()];
        for(int i=0; i<ans.length; i++) {
        	ans[i] = res.get(i);
        }
        return ans;
    }
	
	private int midCount(Map<Integer, Integer> count, TreeNode node) {
		if(node == null) return 0;
		int sum = this.midCount(count, node.left) + this.midCount(count, node.right) + node.val;
		if(count.containsKey(sum)) {
			count.put(sum, count.get(sum) + 1);
			maxCount = Math.max(count.get(sum), maxCount);
		}
		else {
			count.put(sum, 1);
		}
		return sum;
	}
	
}

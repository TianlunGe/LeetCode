package leet.medium;

import java.util.ArrayList;
import java.util.List;

import leet.util.TreeNode;

public class Leet113PathSumII {
	//方法1，自己做的，内数组用的ArrayList每次往下传需要新建一个List，每层都要新建，因此比方法2效率低。
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null){
			return res;
		}
		pathSum(root, sum, res, new ArrayList<Integer>());
		return res;
    }
	
	private void pathSum(TreeNode root, int sum, List<List<Integer>> res, List<Integer> temp){
		if(root == null){
			return;
		}
		temp.add(root.val);
		sum -= root.val;
		if(sum == 0 && root.left == null && root.right == null){
			res.add(temp);
		}
		pathSum(root.left, sum, res, new ArrayList<Integer>(temp));
		pathSum(root.right, sum, res, new ArrayList<Integer>(temp));
	}
	
	//方法2，内层List用LinkedList，只有找到符合要求的List在新建一个List，因此效率较高。每次用完移除最后一个数保证正确性。
	/*public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null){
			return res;
		}
		pathSum(root, sum, res, new LinkedList<Integer>());
		return res;
    }
	
	private void pathSum(TreeNode root, int sum, List<List<Integer>> res, List<Integer> temp){
		if(root == null){
			return;
		}
		temp.add(root.val);
		sum -= root.val;
		if(sum == 0 && root.left == null && root.right == null){
			res.add(new LinkedList<Integer>(temp));
			temp.remove(temp.size() - 1);
			return;
		}
		pathSum(root.left, sum, res, temp);
		pathSum(root.right, sum, res, temp);
		temp.remove(temp.size() - 1);
	}*/
}

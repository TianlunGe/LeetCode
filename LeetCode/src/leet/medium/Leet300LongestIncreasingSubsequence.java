package leet.medium;

import org.junit.Test;

public class Leet300LongestIncreasingSubsequence {
	
	@Test
	public void test(){
		this.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
	}
	
	public int lengthOfLIS(int[] nums) {
		//O(N^2)解法
		/*if(nums == null || nums.length < 1){
			return 0;
		}
		int[] len = new int[nums.length];
		for(int i=len.length-1; i>=0; i--){
			int mark = nums[i];
			int max = len[i];
			for(int j=i; j<len.length; j++){
				if(nums[j] > mark){
					max = Math.max(max, len[j]);
				}
			}
			len[i] += max + 1;
		}
		int res = 0;
		for(int i : len){
			res = Math.max(res, i);
		}
		return res;*/
		
		//O(NlogN)解法
		int[] tails = new int[nums.length];
	    int size = 0;
	    for (int x : nums) {
	        int i = 0, j = size;
	        while (i != j) {
	            int m = (i + j) / 2;
	            if (tails[m] < x)
	                i = m + 1;
	            else
	                j = m;
	        }
	        tails[i] = x;
	        if (i == size) ++size;
	    }
	    return size;
		
    }
}

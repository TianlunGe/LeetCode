package leet.medium;

import java.util.Arrays;

public class Leet503NextGreaterElementII {
	
	public static void main(String[] args) {
		Leet503NextGreaterElementII t = new Leet503NextGreaterElementII();
		System.out.println(Arrays.toString(t.nextGreaterElements(new int[] {4,3,2,1})));
	}
	
	public int[] nextGreaterElements(int[] nums) {
		int len = nums.length;
		int[] ans = new int[len];
		for(int i=0; i<len;) {
			int stop = this.findDesc(nums, len, i);
			int mid = stop;
			for(int j=stop+1; j<=i+len; j++) {
				while(mid >= i && nums[j%len] > nums[mid%len]) {
					ans[mid%len] = nums[j%len];
					mid--;
				}
				if(mid < i) break;
			}
			for(int k=i; k<=mid; k++) ans[k%len] = -1;
			i = stop + 1;
		}
		return ans;
	}
	
	private int findDesc(int[] nums, int len, int start) {
		int res = start + 1;
		for(; res<start+len; res++) {
			if(nums[(res-1)%len] < nums[res%len]) return res-1;
		}
		return res-1;
	}
}

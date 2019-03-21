package leet.easy;

public class Leet747LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
    	int index = 0;
        int max = 0, secMax = 0;
        for(int i=0; i<nums.length; i++) {
        	if(nums[i] > max) {
        		max = nums[i];
        		index = i;
        	}
        }
        for(int num : nums) {
        	if(num > secMax && num < max) secMax = num;
        }
        return max >= 2 * secMax ? index : -1;
    }
}

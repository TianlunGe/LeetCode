package leet.easy;

public class Leet724FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        int leftSum = 0;
        for(int i=0; i<nums.length; i++) {
        	if(leftSum == sum - nums[i]) return i;
        	leftSum += nums[i];
        	sum -= nums[i];
        }
        return -1;
    }
}

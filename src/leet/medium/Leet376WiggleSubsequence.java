package leet.medium;

public class Leet376WiggleSubsequence {
	
	public static void main(String[] args) {
		Leet376WiggleSubsequence t = new Leet376WiggleSubsequence();
		System.out.println(t.wiggleMaxLength(new int[]{0,1,2,3,4,1}));
	}
	
	public int wiggleMaxLength(int[] nums){
		int res = nums.length;
        if(res < 2) return res;
        int pre = 0, cur = 1;
        for(int i=1; i<nums.length-1; i++){
        	if((nums[i]>nums[pre] && nums[i+1]<nums[i]) || (nums[i]<nums[pre] && nums[i+1]>nums[i])){
        		pre = i;
        		continue;
        	}
        	if(nums[i] == nums[pre]){
        		res--;
        	}
        	if((nums[i]>nums[pre] && nums[i+1]>=nums[i]) || (nums[i]<nums[pre] && nums[i+1]<=nums[i])){
        		res--;
        	}
        }
        if(nums[nums.length-1] == nums[pre]) res--;
        return res;
	}
	
}

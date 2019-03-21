package leet.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet15ThreeSum {
	
	
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<=nums.length-3; i++){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
        	twoSum(nums, i, res);
        }
        return res;
    }

	private void twoSum(int[] nums, int i, List<List<Integer>> res) {
		int lo = i + 1;
		int hi = nums.length - 1;
		while(lo < hi){
			int sum = nums[i] + nums[lo] + nums[hi];
			if(sum > 0){
				hi--;
			}
			else if(sum < 0){
				lo++;
			}
			else{
				List<Integer> temp = new ArrayList<>();
				temp.add(nums[i]);
				temp.add(nums[lo]);
				temp.add(nums[hi]);
				res.add(temp);
				lo++;
				while(lo < hi && nums[lo] == nums[lo-1]){
					lo++;
				}
			}
		}
	}
	
}

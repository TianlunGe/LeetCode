package leet.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leet287FindDuplicateNumber {
	public int findDuplicate(int[] nums) {
        /*Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
        	if(set.contains(nums[i])){
        		return nums[i];
        	}
        	else{
        		set.add(nums[i]);
        	}
        }
        return -1;*/
		
		/*Arrays.sort(nums);
		for(int i=1; i<nums.length; i++){
			if(nums[i] == nums[i-1]){
				return nums[i];
			}
		}
		return -1;*/
		
		for(int i=0; i<nums.length-1; i++){
			for(int j=i+1; j<nums.length; j++){
				if(nums[j] == nums[i]){
					return nums[j];
				}
			}
		}
		return -1;
    }
}

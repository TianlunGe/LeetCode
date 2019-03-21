package leet.medium;

import java.util.Arrays;

import org.junit.Test;

public class Leet334IncreasingTripletSubsequence {
	public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3){
        	return false;
        }
        int[] temp = new int[3];
        int max = nums[0];
        for(int i : nums){
        	max = Math.max(max, i);
        }
        Arrays.fill(temp, max);
        for(int i=0; i<nums.length; i++){
        	if(nums[i] == temp[0] || nums[i] == temp[1]){
        	}
        	else if(nums[i] < temp[0]){
        		temp[0] = nums[i];
        	}
        	else if(nums[i] < temp[1]){
        		temp[1] =nums[i];
        	}
        	else{
        		return true;
        	}
        }
        return false;
    }
}

package leet.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet368LargestDivisibleSubset {
	
	//DP
	public List<Integer> largestDivisibleSubset(int[] nums) {
		if(nums.length < 1){
			return new ArrayList<Integer>();
		}
		Arrays.sort(nums);
        int len = nums.length;
		int[] to = new int[len];
        int[] max = new int[len];
        max[len - 1] = 1;
        to[len - 1] = len - 1;
        for(int i=len-2; i>=0; i--){
        	int maxLen = 1;
        	int index = i;
        	for(int j=i+1; j<len; j++){
        		if(nums[j]%nums[i] == 0 && max[j] > maxLen - 1){
        			maxLen = max[j] + 1;
        			index = j;
        		}
        	}
        	max[i] = maxLen;
        	to[i] = index;
        }
        int maxLen = max[0];
        int index = 0;
        for(int i=0; i<len; i++){
        	if(max[i] > maxLen){
        		maxLen = max[i];
        		index = i;
        	}
        }
        List<Integer> res = new ArrayList<>();
        while(index != to[index]){
        	res.add(nums[index]);
        	index = to[index];
        }
        res.add(nums[index]);
        return res;
    }
}

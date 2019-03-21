package leet.easy;

import java.util.Arrays;

import org.junit.Test;

public class Leet414ThirdMaximumNumber {
	
	@Test
	public void test(){
		System.out.println(this.thirdMax(new int[]{3,2,2,3,2,3}));
	}
	
	/*public int thirdMax(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i : nums){
        	q.add(i);
        }
        int index = 2;
        int res = q.poll();
        int pre = res;
        while(!q.isEmpty() && index > 0){
        	int cur = q.poll();
        	if(cur == pre){
        		continue;
        	}
        	else {
        		pre = cur;
        		index--;
        	}
        }
        if(index == 0){
        	res = pre;
        }
        return res;
    }*/
	
	public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int index = 2;
        for(int i=nums.length-2; i>=0; i--){
        	
        	if(nums[i] == nums[i+1]){
        		continue;
        	}
        	else{
        		index--;
        	}
        	if(index == 0){
        		return nums[i];
        	}
        }
        return nums[nums.length - 1];
    }
	
}

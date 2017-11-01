package leet.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Leet398RandomPickIndex {
	public Leet398RandomPickIndex(int[] nums) {
        map = new HashMap<>();
        rnd = new Random();
        for(int i=0; i<nums.length; i++){
        	if(map.containsKey(nums[i])){
        		map.get(nums[i]).add(i);
        	}
        	else{
        		List<Integer> list = new ArrayList<>();
        		list.add(i);
        		map.put(nums[i], list);
        	}
        }
    }
    
	Map<Integer, List<Integer>> map;
	Random rnd;
	
    public int pick(int target) {
    	List<Integer> list = map.get(target);
        return list.get(rnd.nextInt(list.size()));
    }
}

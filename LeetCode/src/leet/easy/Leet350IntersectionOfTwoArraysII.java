package leet.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet350IntersectionOfTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i1 = 0, i2 = 0;
        while(i1 < nums1.length && i2 < nums2.length){
        	if(nums1[i1] < nums2[i2]){
        		i1++;
        	}
        	else if(nums1[i1] > nums2[i2]){
        		i2++;
        	}
        	else{
        		list.add(nums1[i1]);
        		i1++;
        		i2++;
        	}
        }
        int[] res = new int[list.size()];
        int index = 0;
        for(int i : list){
        	res[index++] = i;
        }
        return res;
    }
}

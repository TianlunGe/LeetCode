package leet.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leet349IntersectionOfTwoArrays {
	/*public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        for(int i : nums1){
        	set1.add(i);
        }
        for(int i : nums2){
        	set2.add(i);
        }
        for(int i : set1){
        	if(set2.contains(i)){
        		set3.add(i);
        	}
        }
        int[] res = new int[set3.size()];
        int index = 0;
        for(int i : set3){
        	res[index++] = i;
        }
        return res;
    }*/
	
	//先排序在查找，速度比上一种快。
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
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
        		set.add(nums1[i1]);
        		i1++;
        		i2++;
        	}
        }
        int[] res = new int[set.size()];
        int index = 0;
        for(int i : set){
        	res[index++] = i;
        }
        return res;
    }
	
	//O(n)
	/*public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }*/
}

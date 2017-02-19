package leet.medium;

import java.util.Arrays;

import org.junit.Test;

public class Leet274HIndex {
	
	@Test
	public void test(){
		int[] a = {100};
		System.out.println(this.hIndex(a));
	}
	//方法2：建立一个长度比原数组长1的数组，这个数组的下标表示引用次数，把每个引用次数记录再这个数组里，如果大于数组长度则记录再最后。
	//从后往前相加，h表示引用次数大于i的论文数量，如果h<i表示引用次数超过i的只有h篇，h不是h-index，h-index还在前面；
	//直到h>=i，表示有至少i篇论文引用次数超过i，这个i就是最大的h-index。
	public int hIndex(int[] citations) {
		if(citations.length < 1){
            return 0;
        }
		int len = citations.length;
		int[] cita = new int[len + 1];
		for(int i : citations){
			if(i > len){
				cita[len]++;
				continue;
			}
			cita[i]++;
		}
		int h = 0;
		int i;
		for(i=len; i>=0; i--){
			h += cita[i];
			if(h >= i){
				return i;
			}
		}
		return -1;
    }
	
	//方法1：先排序，再计数。
	/*public int hIndex(int[] citations) {
		if(citations.length < 1){
            return 0;
        }
        Arrays.sort(citations);
        int nums = 1;
        for(int i=citations.length-1; i>=0; i--){
        	if(citations[i] >= nums){
        		nums++;
        	}
        	else{
        		break;
        	}
        }
        return nums - 1;
    }*/
}

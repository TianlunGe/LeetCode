package leet.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Leet401BinaryWatch {
	public List<String> readBinaryWatch(int num) {
		List<String> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
        for(int i=0; i<4; i++){
        	if(num - i < 0 || num - i > 5){
        		continue;
        	}
        	int[] hours = getHours(i);
        	int[] mins = getMins(num - i);
        	for(int hour : hours){
        		for(int min : mins){
        			sb.append(hour + ":");
        			if(min < 10){
        				sb.append(0);
        			}
        			sb.append(min);
        			res.add(sb.toString());
        			sb.delete(0, sb.length());
        		}
        	}
        }
        return res;
    }

	int[] mins = {1, 2, 4, 8, 16, 32};
	
	private int[] getMins(int i) {
		int[] res = null;
		switch(i){
		case 0: res = new int[]{0}; break;
		case 1: res = mins; break;
		case 2:
			res = getMinHeplerTwo();
			break;
		case 3:
			res = new int[20];
			int index = 0;
			for(int l=0; l<mins.length-2; l++){
				for(int m=l+1; m<mins.length-1; m++){
					for(int n=m+1; n<mins.length; n++){
						res[index++] = mins[m] + mins[n] + mins[l];
					}
				}
			}
			break;
		case 4:
			res = new int[14];
			int[] two = this.getMinHeplerTwo();
			for(int k=1; k<two.length; k++){
				res[k-1] = 63 - two[k];
			}
			break;
		case 5: res = new int[]{59, 55, 47, 31}; break;
		}
		return res;
	}

	private int[] getHours(int i) {
		int[] res = null;
		switch(i){
		case 0: res = new int[]{0}; break;
		case 1: res = new int[]{1, 2, 4, 8}; break;
		case 2: res = new int[]{3, 5, 6, 9, 10}; break;
		case 3: res = new int[]{7, 11}; break;
		}
		return res;
	}
	
	private int[] getMinHeplerTwo(){
		int[] res = new int[15];
		int index = 0;
		for(int m=0; m<mins.length-1; m++){
			for(int n=m+1; n<mins.length; n++){
				res[index++] = mins[m] + mins[n];
			}
		}
		return res;
	}
	
	@Test
	public void test(){
		System.out.println(Arrays.toString(this.getMins(3)));
	}
	
}

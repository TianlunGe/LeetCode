package leet.medium;

import org.junit.Test;

public class Leet372SuperPow {
	@Test
	public void test(){
		System.out.println(3714151%1337);
		System.out.println(this.superPow(1302 + 1337, new int[]{5,6,7,4,9}));
		System.out.println(Long.MAX_VALUE);
	}
	
	public int superPow(int a, int[] b) {
        return this.superPow(a%1337, b, 0);
    }
	
	public int superPow(int a, int[] b, int start){
		while(start < b.length && b[start] == 0){
			start++;
		}
		if(start == b.length){
			return 1;
		}
		if(start == b.length - 1 && b[start] == 1){
			return a%1337;
		}
		int y = 0;
		for(int i=start; i<b.length; i++){
			int x = y * 10 + b[i];
			b[i] = x / 2;
			y = x % 2;
		}
		int rest = 1;
		if(y == 1){
			rest = a;
		}
		int nextLevel = superPow(a, b, start)%1337;
		return (nextLevel * nextLevel)%1337 * rest%1337;
	}
	
}

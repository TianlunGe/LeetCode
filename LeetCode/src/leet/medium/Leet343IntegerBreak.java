package leet.medium;

import org.junit.Test;

public class Leet343IntegerBreak {
	
	@Test
	public void test(){
		System.out.println(this.integerBreak(10));
	}
	
	public int integerBreak(int n) {
        int res = n - 1;
        for(int i=2; i<=n/2; i++){
        	res = Math.max(res, multi(n, i));
        }
        return res;
    }
	
	private int multi(int n, int i){
		int times = n/i;
		int res = 0;
		if(n%i == 1){
			res = (int) Math.pow(i, times - 1) * (i + 1);
		}
		else{
			res = (int) Math.pow(i, times);
			if(n%i != 0){
				res *= n%i;
			}
		}
		return res;
	}
	
}

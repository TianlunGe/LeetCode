package leet.medium;

import org.junit.Test;

public class Leet319BulbSwitcher {
	
	@Test
	public void test(){
		System.out.println(this.bulbSwitch(345765));
	}
	
	public int bulbSwitch(int n) {
		/*
		 * 数字的除数个数，如果除数个数是奇数，结果为on，否则是off。
		 * 除了完全平方数，其余数字的因子都是成对出现的，而完全平方数的平方根只会统计一次。
		 * 所以答案是sqrt(n)。
		 */
        return (int) Math.sqrt(n);
        
        /*
         * 原解法：找规律：遇到1on、2off、1on、4off、1on、6off、1on、8off。。。
         */
        /*if(n < 1){
	    	return 0;
	    }
	    if(n == 1){
	    	return 1;
	    }
	    int res = 1;
	    for(int i=0; ; i++){
	    	if(n > (i * i + 4 * i + 3)){
	    		res++;
	    	}
	    	else{
	    		return res;
	    	}
	    }*/
    }
	
	
}

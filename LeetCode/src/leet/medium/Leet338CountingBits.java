package leet.medium;

import org.junit.Test;

public class Leet338CountingBits {
	
	@Test
	public void test(){
		this.countBits(100);
	}
	//长度每增加一位，就是在少一位的数列每个+1。如两位为00，01，10，11。三位为100，101，110，111；把第一位1去掉，就是前面的数列位数。
	public int[] countBits(int num) {
        int[] res = new int[num + 1];
        if(num == 0){
        	return res;
        }
        else if(num == 1){
        	res[1] = 1;
        	return res;
        }
        res[1] = 1;
        int i = 2;
        int flag = 2;
        while(i < res.length){
        	if(i < 2 * flag){
        		res[i] = res[i - flag] + 1;
        	}
        	else{
        		flag *= 2;
        		res[i] = res[i - flag] + 1;
        	}
        	i++;
        }
        return res;
    }
}

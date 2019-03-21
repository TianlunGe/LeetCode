package leet.hard;

import java.util.Arrays;

import org.junit.Test;

public class Leet600NonNegativeIntegersWithoutConsecutiveOnes {
	@Test
	public void test() {
		System.out.println(this.findIntegers(6));
		for(int i=1; i<11; i++) {
			System.out.print(i + ":" + Integer.toBinaryString(i) + ":");
			System.out.println(this.findIntegers(i));
		}
	}
	//假设f(n)是二进制位数n与满足条件的个数关系，g(n)是其中以0开头的个数
	//思路：当二进制位只有1位时，任取0、1都符合条件，有2种，f(1)=2，其中首位为0的情况g(1)=1；
	//二进制有2位时，首位加0时f(1)肯定都满足条件，首位加1则只有第二位为0时满足，f(2)=f(1)+g(1)，g(2)=f(1)
	//可以得到递推关系f(n)=f(n-1)+g(n-1),其中g(n)=f(n-1)；
	
	//因此先得到num的二进制形式，首位一定为1，先假设首位为0，则剩下的(n-1)位可以是任意的满足形式的组合ans+=f(n-1);
	//再考虑首位为1的情况，首位确定为1 ，将其移除，考虑剩下的数按递归方式求解。
	public int findIntegers(int num) {
        int len = Integer.toBinaryString(num).length();
        if(len == 1) return 2;
        int[] cache = new int[len];
        cache[0] = 2;
        int zero = 1;
        for(int i=1; i<len; i++) {
        	cache[i] = cache[i-1] + zero;
        	zero = cache[i-1];
        }
        return this.find(cache, num);
    }
	
	private int find(int[] cache, int num) {
		if(num == 0) return 1;
		if(num == 1) return 2;
		int len = Integer.toBinaryString(num).length();
		int minus = (int) Math.pow(2, len - 2);
		num -= minus * 2;
		if(num >= minus) num = minus - 1;
		return cache[len - 2] + this.find(cache, num);
	}
	
}

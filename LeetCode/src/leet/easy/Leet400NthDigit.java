package leet.easy;

import org.junit.Test;

public class Leet400NthDigit {
	@Test
	public void test(){
		System.out.println(this.findNthDigit(1000000000));
	}
	
	public int findNthDigit(int n) {
        long flag = 9;
        long index = 1;
        long temp = n;
        while(temp > 0){
        	temp -= flag * index;
        	flag *= 10;
        	index++;
        }
        index--;
        flag /= 10;
        temp += flag * index;
        flag = (int)Math.pow(10, index-1) - 1;
        flag += temp/index;
        int res = 0;
        int s = (int) (temp % index);
        if(s == 0){
        	res = (int) (flag % 10);
        }
        else{
        	flag++;
        	res = nth(flag, s);
        }
        return res;
    }

	private int nth(long flag, int s) {
		int digs = 0;
		int nums = (int) flag;
		while(nums / 10 != 0){
			nums /= 10;
			digs++;
		}
		int c = (int) Math.pow(10, digs);
		int res = 0;
		while(s > 0){
			res = (int) (flag / c);
			flag %= c;
			c /= 10;
			s--;
		}
		return res;
	}
}

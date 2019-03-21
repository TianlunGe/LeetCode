package leet.easy;

import org.junit.Test;

public class Leet409LongestPalindrome {
	
	@Test
	public void test(){
		System.out.println(this.longestPalindrome("ioufduIHSAUIDHoijisud"));
	}
	
	public int longestPalindrome(String s) {
		char[] cs = s.toCharArray();
		int[] count = new int[52];
		for(char c : cs){
			if(c <= 90){
				count[c - 'A']++;
			}
			else{
				count[c - 'a' + 26]++;
			}
		}
		int res = 0;
		int odd = 0;
		for(int i : count){
			if(i % 2 == 0){
				res += i;
			}
			else {
				res += i - 1;
				odd = 1;
			}
		}
		return res + odd;
    }
	
}

package leet.medium;

import org.junit.Test;

public class Leet306AdditiveNumber {
	
	@Test
	public void aa(){
		System.out.println(this.isAdditiveNumber("101"));
	}
	
	public boolean isAdditiveNumber(String num) {
		if(num.length() < 3){
			return false;
		}
        int len = num.length(), e = (len/3)*2;
        for(int i=1; i<e; i++){
        	for(int j=1; j<=e-i; j++){
        		if(isAdditive(num, 0, i, j)){
        			return true;
        		}
        	}
        }
        return false;
    }
	
	private boolean isAdditive(String num, int s, int l1, int l2){
		int len = num.length();
		if(s > len || s+l1 >= len || s+l1+l2 >= len){
			return false;
		}
		String s1 = num.substring(s, s+l1);
		String s2 = num.substring(s+l1, s+l1+l2);
		if(this.startWithZero(s1) || this.startWithZero(s2)){
			return false;
		}
		String sum = String.valueOf(Long.valueOf(s1) + Long.valueOf(s2));
		if(len-s-l1-l2 < sum.length()){
			return false;
		}
		String s3 = num.substring(s+l1+l2, s+l1+l2+sum.length());
		if(!sum.equals(s3)){
			return false;
		}
		if(s+l1+l2+sum.length() == len){
			return true;
		}
		return isAdditive(num, s+l1, l2, sum.length());
	}
	
	private boolean startWithZero(String s){
		return s.length() > 1 && s.charAt(0) == '0';
	}
	
}

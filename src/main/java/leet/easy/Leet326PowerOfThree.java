package leet.easy;

public class Leet326PowerOfThree {
	
	public static void main(String[] args){
		System.out.println("qwe");
	}
	
	public boolean isPowerOfThree(int n) {
        if(n < 1){
        	return false;
        }
		while(n != 1){
        	if(n % 3 != 0){
        		return false;
        	}
        	n /= 3;
        }
        return true;
    }
}

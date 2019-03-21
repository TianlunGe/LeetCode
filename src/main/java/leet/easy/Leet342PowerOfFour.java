package leet.easy;

public class Leet342PowerOfFour {
	public boolean isPowerOfFour(int num) {
		while(num != 1){
        	if(num % 4 != 0){
        		return false;
        	}
        	num /= 4;
        }
        return true;
    }
}

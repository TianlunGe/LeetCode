package leet.easy;

public class Leet367ValidPerfectSquare {
	//二分法，找到mid * mid == num返回ture，否则返回false。
	public boolean isPerfectSquare(int num) {
        if(num < 0){
        	return false;
        }
        else if(num < 2){
        	return true;
        }
        long lo = 1, hi = num/2;
        long mid;
        while(lo <= hi){
        	mid = (lo + hi)/2;
        	long temp = mid * mid;
        	if(temp > num){
        		hi = mid - 1;
        	}
        	else if(temp < num){
        		lo = mid + 1;
        	}
        	else{
        		return true;
        	}
        }
        return false;
    }
}

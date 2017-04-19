package leet.medium;

public class Leet357CountNumbersWithUniqueDigits {
	public int countNumbersWithUniqueDigits(int n) {
        int[] nums = new int[11];
        nums[0] = 1;
        nums[1] = 9;
        int flag = 9;
        for(int i=2; i<nums.length; i++){
        	nums[i] = nums[i-1] * flag--;
        }
        int res = 0;
        if(n > 10){
        	n = 10;
        }
        for(int i=0; i<=n; i++){
        	res += nums[i];
        }
        return res;
    }
}

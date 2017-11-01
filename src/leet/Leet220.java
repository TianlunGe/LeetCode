package leet;

public class Leet220 {
	public static void main(String[] args) {
		int[] a = {-1,2147483647};
		System.out.println(new Leet220().containsNearbyAlmostDuplicate(a, 1, 2147483647));
	}
	
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1){
        	return false;
        }
        if(k >= nums.length){
        	return helper(nums, 0, nums.length-1, t);
        }
        else{
        	for(int i=0; i<nums.length-k; i++){
        		if(helper(nums, i, i+k, t)){
        			return true;
        		}
        	}
        }
        return false;
    }
	
	private boolean helper(int[] nums, int l , int r, int t){
		long res = Long.MAX_VALUE;
		for(int i=l; i<=r; i++){
			for(int j=i+1; j<=r; j++){
				res = Math.min(res, Math.abs((long)nums[i] - (long)nums[j]));
				if(res <= t){
					return true;
				}
			}
		}
		return false;
	}
	
}

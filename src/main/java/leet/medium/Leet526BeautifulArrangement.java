package leet.medium;

public class Leet526BeautifulArrangement {
	public static void main(String[] args) {
		Leet526BeautifulArrangement t = new Leet526BeautifulArrangement();
		System.out.println(t.countArrangement(15));
	}
	
	int ans = 0;
    public int countArrangement(int N) {
        int[] nums = new int[N];
        for(int i=0; i<N; i++) nums[i] = i + 1;
        this.count(nums, 0);
        return ans;
    }
    
    private void count(int[] nums, int start) {
    	if(start == nums.length-1) {
    		int tmp = 0;
    		for(int i=0; i<=nums.length; i++) {
    			if(nums[i] != 0) {
    				tmp = nums[i];
    				break;
    			}
    		}
    		if(tmp % nums.length == 0 || nums.length % tmp == 0) {
    			ans++;
    			return;
    		}
    	}
    	for(int i=0; i<nums.length; i++) {
    		if(nums[i] == 0) continue;
    		int tmp = nums[i];
    		nums[i] = 0;
    		this.count(nums, start + 1);
    		nums[i] = tmp;
    	}
    }
    
}

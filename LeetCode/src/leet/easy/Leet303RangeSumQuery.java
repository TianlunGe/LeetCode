package leet.easy;

/*
 * sumRange方法调用次数很多，如果每次计算效率很低，需要将和保存下来。
 */
public class Leet303RangeSumQuery {
	int[] nums;
	
    public Leet303RangeSumQuery(int[] nums) {
    	this.nums = nums;
    	for(int i=1; i<nums.length; i++){
    		nums[i] += nums[i-1];
    	}
    }
    
    public int sumRange(int i, int j) {
    	if(i > 0){
    		return nums[j] - nums[i-1];
    	}
    	return nums[j];
    }
}

package leet.easy;

public class Leet697DegreeOfAnArray {

    public static void main(String[] args) {
        System.out.println(new Leet697DegreeOfAnArray().findShortestSubArray(new int[]{1,2,2,3,1}));
    }

    public int findShortestSubArray(int[] nums) {
        int[] count = new int[50000];
        for(int i : nums){
            count[i]++;
        }
        int max = 0;
        for(int i : count){
            max = max > i ? max : i;
        }
        int res = nums.length;
        for(int i=0; i<count.length; i++){
            if(count[i] == max){
                int left = 0, right = nums.length-1;
                for(int l=0; l<=right; l++){
                    if(nums[l] == i){
                        left = l;
                        break;
                    }
                }
                for(int r=right; r>=left; r--){
                    if(nums[r] == i){
                        right = r;
                        break;
                    }
                }
                int tmp = right - left + 1;
                res = res > tmp ? tmp : res;
            }
        }
        return res;
    }
}

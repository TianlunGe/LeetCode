package leet.medium;


public class Leet930BinarySubarraysWithSum {

    public int numSubarraysWithSum(int[] A, int S) {
        int res = 0;
        int sum = 0;
        int leftIdx = 0;
        int rightIdx = 0;
        int midL = 0;
        int midR = 0;
        int leftZ = 0;
        int rightZ = 0;
        while (rightIdx < A.length) {
            for (int i=midR; i<A.length; i++) {
                sum += A[i];
                if (sum == S) {
                    midR = i;
                    break;
                }
            }
            for (int i=leftIdx; i<midL; i++) {
                if (A[i] == 0) {
                    leftZ++;
                } else {
                    break;
                }
            }
            for (int i=midR; i<A.length; i++) {
                if (A[i] == 0) {
                    rightZ++;
                } else {
                    break;
                }
                rightIdx = i + 1;
            }
            res += (1 + leftZ) * (1 + rightZ);
            midL++;
            sum -= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        new Leet930BinarySubarraysWithSum().numSubarraysWithSum(new int[]{1,0,1,0,1}, 2);
    }

}

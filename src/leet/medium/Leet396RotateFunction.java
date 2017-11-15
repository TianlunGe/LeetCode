package leet.medium;

public class Leet396RotateFunction {
    public int maxRotateFunction(int[] A) {
        int max = 0;
        int sum = 0;
        int n = A.length;
        for (int i=0; i<n; i++){
            max += i * A[i];
            sum += A[i];
        }
        int cur = max;
        for (int i=n-1; i>0; i--){
            cur += sum;
            cur -= n * A[i];
            if(cur > max) max = cur;
        }
        return max;
    }
}

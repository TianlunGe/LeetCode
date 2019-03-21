package leet.medium;

public class Leet304RangeSumQuery2DImmutable {
	//更好的解法，创建一个行列都比原来数组大1的二维数组，这样在sumRegion中不需要判断r1和c1是不是大于0。
	/*private int[][] dp;

	public NumMatrix(int[][] matrix) {
	    if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
	        return;   
	    }
	    
	    int m = matrix.length;
	    int n = matrix[0].length;
	    
	    dp = new int[m + 1][n + 1];
	    for(int i = 1; i <= m; i++){
	        for(int j = 1; j <= n; j++){
	            dp[i][j] = dp[i - 1][j] + dp[i][j - 1] -dp[i - 1][j - 1] + matrix[i - 1][j - 1] ;
	        }
	    }
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
	    int iMin = Math.min(row1, row2);
	    int iMax = Math.max(row1, row2);
	    int jMin = Math.min(col1, col2);
	    int jMax = Math.max(col1, col2);
	    
	    return dp[iMax + 1][jMax + 1] - dp[iMax + 1][jMin] - dp[iMin][jMax + 1] + dp[iMin][jMin];    
	}*/
	
	int[][] sum;
	public Leet304RangeSumQuery2DImmutable(int[][] matrix) {
		if(matrix.length == 0 || matrix[0].length == 0){
			return;
		}
        sum = new int[matrix.length][matrix[0].length];
        sum[0][0] = matrix[0][0];
        for(int i=1; i<matrix.length; i++){
        	sum[i][0] = sum[i-1][0] + matrix[i][0];
        }
        for(int i=1; i<matrix[0].length; i++){
        	sum[0][i] = sum[0][i-1] + matrix[0][i];
        }
        for(int i=1; i<sum.length; i++){
        	for(int j=1; j<sum[0].length; j++){
        		sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i][j];
        	}
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int a1, a2, a3, a4;
        a1 = sum[row2][col2];
        if(row1 - 1 >= 0){
        	a2 = sum[row1 - 1][col2]; 
        }
        else{
        	a2 = 0;
        }
        if(col1 - 1 >= 0){
        	a3 = sum[row2][col1 - 1];
        }
        else{
        	a3 = 0;
        }
        if(row1 - 1 >= 0 && col1 - 1 >= 0){
        	a4 = sum[row1 - 1][col1 - 1];
        }
        else{
        	a4 = 0;
        }
        return a1 - a2 - a3 + a4;
    }
}

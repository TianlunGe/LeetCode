package leet.medium;

import org.junit.Test;

public class Leet576OutOfBoundaryPaths {
	@Test
	public void test() {
		System.out.println(this.findPaths(8, 7, 16, 1, 5));
	}
	
	int mod = (int) Math.pow(10, 9) + 7;
	public int findPaths(int m, int n, int N, int i, int j) {
		int[][] paths = new int[m][n];
        paths[i][j] = 1;
        int count = 0;
        for(int move=1; move<=N; move++) {
        	int[][] tmp = new int[m][n];
        	for(int k=0; k<m; k++) {
        		for(int l=0; l<n; l++) {
        			if (k == m - 1)
                        count = (count + paths[k][l]) % mod;
                    if (l == n - 1)
                        count = (count + paths[k][l]) % mod;
                    if (k == 0)
                        count = (count + paths[k][l]) % mod;
                    if (l == 0)
                        count = (count + paths[k][l]) % mod;
        			/*if(k - 1 >= 0) tmp[k][l] += paths[k-1][l];
        			if(k + 1 < m) tmp[k][l] += paths[k+1][l];
        			if(l - 1 >= 0) tmp[k][l] += paths[k][l-1];
        			if(l + 1 < n) tmp[k][l] += paths[k][l+1];
        			tmp[k][l] %= mod;*/
                    tmp[k][l] = (((k > 0 ? paths[k - 1][l] : 0) + (k < m - 1 ? paths[k + 1][l] : 0)) % mod + ((l > 0 ? paths[k][l - 1] : 0) + (l < n - 1 ? paths[k][l + 1] : 0)) % mod) % mod;
        		}
        	}
        	paths = tmp;
        }
//        tmp[i][j] = (((i > 0 ? paths[i - 1][j] : 0) + (i < m - 1 ? paths[i + 1][j] : 0)) % mod + ((j > 0 ? paths[i][j - 1] : 0) + (j < n - 1 ? paths[i][j + 1] : 0)) % mod) % mod;
        return count;
    }
	
}

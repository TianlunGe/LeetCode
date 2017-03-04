package leet.hard;

public class Leet329LongestIncreasingPathInAMatrix {
	
	//思路：新建一个与matrix大小一样的二维数组，用来保存matrix上某位置的数的最大递增路径。某一点的最大路径是这一点四个方向路径长度的最大值+1。
	//只要点存在，长度至少为1，因此初始化后path各点为0，遍历path数组，如果值不为0，说明已经找到这点最大路径，跳过；如果为0，说明这点没有被计算过，传入计算函数。
	//计算函数找传入点在path的四个方向的值，如果为0，计算这点的路径，最后把四个方向最大值+1返回给这点。
	//最后遍历path数组，找到最大值就是答案。
	public int longestIncreasingPath(int[][] matrix) {
		if(matrix.length == 0 || matrix[0].length == 0){
			return 0;
		}
        int[][] path = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++){
        	for(int j=0; j<matrix[0].length; j++){
        		if(path[i][j] == 0){
        			path[i][j] = count(matrix, path, i, j);
        		}
        	}
        }
        int max = 0;
        for(int[] array : path){
        	for(int a : array){
        		max = Math.max(a, max);
        	}
        }
        return max;
    }
	
	private int count(int[][] matrix, int[][] path, int i, int j) {
		int u = 0, d = 0, l = 0, r = 0;
		if(i - 1 >= 0 && matrix[i-1][j] < matrix[i][j]){
			if(path[i-1][j] == 0){
				path[i-1][j] = count(matrix, path, i-1, j);
			}
			u = path[i-1][j];
		}
		if(i + 1 < matrix.length && matrix[i+1][j] < matrix[i][j]){
			if(path[i+1][j] == 0){
				path[i+1][j] = count(matrix, path, i+1, j);
			}
			d = path[i+1][j];
		}
		if(j - 1 >= 0 && matrix[i][j-1] < matrix[i][j]){
			if(path[i][j-1] == 0){
				path[i][j-1] = count(matrix, path, i, j-1);
			}
			l = path[i][j-1];
		}
		if(j + 1 < matrix[0].length && matrix[i][j+1] < matrix[i][j]){
			if(path[i][j+1] == 0){
				path[i][j+1] = count(matrix, path, i, j+1);
			}
			r = path[i][j+1];
		}
		return 1 + Math.max(Math.max(u, d), Math.max(l, r));
	}

}

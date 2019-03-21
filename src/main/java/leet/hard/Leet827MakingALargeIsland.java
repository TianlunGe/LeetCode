package leet.hard;

import org.junit.Test;

public class Leet827MakingALargeIsland {
	
	public static void main(String[] args) {
		Leet827MakingALargeIsland t = new Leet827MakingALargeIsland();
		System.out.println();
	}
	
	@Test
	public void test() {
		System.out.println(this.largestIsland(new int[][]{{1,1},{1,0}}));
	}
	
	public int largestIsland(int[][] grid) {
		int ans = -1;
        for(int i=0; i<grid.length; i++) {
        	for(int j=0; j<grid[0].length; j++) {
        		if(grid[i][j] == 0) {
        			grid[i][j] = 1;
        			ans = Math.max(ans, this.countNums(grid, i, j));
        			grid[i][j] = 0;
        			this.reset(grid);
        		}
        	}
        }
        return ans < 0 ? grid.length * grid[0].length : ans;
    }

	private int countNums(int[][] grid, int i, int j) {
		int col = grid.length, row = grid[0].length;
		if(i < 0 || i >= col || j < 0 || j >= row || grid[i][j] != 1) return 0;
		int cur = 1;
		if(grid[i][j] == 2) {
			cur = 0;
		}
		grid[i][j] = 2;
		int sum = countNums(grid, i-1, j) + countNums(grid, i+1, j) + countNums(grid, i, j-1) + countNums(grid, i, j+1);
		return cur + sum;
	}
	
	private void reset(int[][] grid) {
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == 2) grid[i][j] = 1;
			}
		}
	}
	
}

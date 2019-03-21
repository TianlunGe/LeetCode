package leet.medium;

public class Leet289GameOfLife {
	/*
	 * 解题思路：遍历整个二维数组，计算周围位置的和，如果位置为1，周围和不为2或3，则这个位置要变成0；如果位置为0，周围和为3，则这个位置变成1。
	 * 原题要求再原来的位置进行变换，不用新建二位数组的方法，可以将1如果变成0先变成2，0如果要变成1先变成-1，这样再后面的遍历中，1和2都当作1，0和-1都当成0。
	 * 最后遍历一次二维数组，将2变成0，将0变成1，就在原位置完成了变换。
	 */
	public void gameOfLife(int[][] board) {
        for(int i=0; i<board.length; i++){
        	for(int j=0; j<board[0].length; j++){
        		int round = countRound(board, i, j);
        		if(board[i][j] == 1){
	        		if(!(round == 2 || round == 3)){
	        			board[i][j] = 2;
	        		}
        		}
        		else{
        			if(round == 3){
        				board[i][j] = -1;
        			}
        		}
        	}
        }
        for(int i=0; i<board.length; i++){
        	for(int j=0; j<board[0].length; j++){
        		if(board[i][j] == 2){
	        		board[i][j] = 0;
        		}
        		else if(board[i][j] == -1){
    				board[i][j] = 1;
        		}
        	}
        }
    }
	
	private int countRound(int[][] board, int i, int j){
		int round = 0;
		round += boo(board, i-1, j-1);
		round += boo(board, i-1, j);
		round += boo(board, i-1, j+1);
		round += boo(board, i, j-1);
		round += boo(board, i, j+1);
		round += boo(board, i+1, j-1);
		round += boo(board, i+1, j);
		round += boo(board, i+1, j+1);
		return round;
	}
	
	private int boo(int[][] board, int i, int j){
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
			return 0;
		}
		if(board[i][j] > 0){
			return 1;
		}
		return 0;
	}
	
}

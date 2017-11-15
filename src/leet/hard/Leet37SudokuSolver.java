package leet.hard;

import java.util.HashSet;

public class Leet37SudokuSolver {
    private static int count=0;
    public static void main(String[] args) {
        char[][] b = {{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
        Leet37SudokuSolver t = new Leet37SudokuSolver();
        t.solveSudoku(b);
        System.out.println(b);
    }

    public void solveSudoku(char[][] board) {
        fill(board, 0, 0);
    }

    private boolean fill(char[][] board, int col, int row){
        System.out.println(count++);
        if(col == board.length && row > board[0].length){
            return leagal(board);
        }
        for (int i=col; i<board.length; i++){
            for(int j=row; j<board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c='1'; c<='9'; c++){
                        board[i][j] = c;
                        if(fill(board, col, row+1)) return true;
                    }
                }
                else{
                    if(fill(board, col, row+1)) return true;
                }
            }
        }
        return false;
    }

    private boolean leagal(char[][] board){
        for(int i = 0; i<9; i++){
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9;j++){
                if(board[i][j]=='.' || !rows.add(board[i][j]))
                    return false;
                if(board[j][i]=='.' || !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]=='.' || !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
            }
        }
        return true;
    }

}

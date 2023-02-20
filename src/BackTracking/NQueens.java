package BackTracking;

public class NQueens {
    
    public static boolean isSafe(char board[][], int row, int col) {
        //up
        for(int i=row-1; i>=0; i--) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        //up left diag
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        //up right diag
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
    
  //Print Board
    public static void printBoard(char board[][]) {
        System.out.println("---- Chess board ----");
        for(int i=0; i<board.length; i++) {  
            for(int j=0; j<board[0].length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    static int countWays = 0;
    public static void nQueens(char board[][], int row) {
        if(row == board.length) {
            printBoard(board); //print board
            countWays++;
            return;
        }
        //column loop
        for(int j=0; j<board[0].length; j++) {
            if(isSafe(board, row, j)) { //if safe then only
                board[row][j] = 'Q'; //PLACE
                nQueens(board, row+1);//next row //func call 
                board[row][j] = 'x'; //bactrack //UNPLACE from same pos as Q
            } 
        }
    }
      
    public static boolean checkNQueens(char board[][], int row) {
        if(row == board.length) {
            return true;
        }
        //cols
        for(int col=0; col<board[0].length; col++) {
            if(isSafe(board, row, col)) {
                board[row][col] = 'Q';
                if(checkNQueens(board, row+1)) {
                    return true;
                }
                board[row][col] = 'x';
            } 
        }
        return false;
    }

    public static void main(String args[]) {
        int n = 4;
        char board[][] = new char[n][n];
            
        //initilaize with empty board with x
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = 'x';
            }
        }
        int row = 0; //1st row
        nQueens(board, row);
        System.out.println("Total number of ways = "+ countWays);

        //--------------------------------------
        if(checkNQueens(board, 0)) {
            System.out.println("solution exists");
            printBoard(board);
        } else {
            System.out.println("NO solution exists");
        }
    }
}
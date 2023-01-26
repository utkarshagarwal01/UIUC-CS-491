import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PlacingQueens {
    static int k,n,m;
    static int countWays;
    public static boolean tryPlacing(boolean[][] board, int row, int col) {
        //For this row, check all columns before this
        // System.out.println("Trying: " + row + " " + col);
        for(int i=0;i<col;i++) {
            if(board[row][i])
                return false;
        }
        //Check upper left diagonal
        for(int i = row, j = col; i>=0 && j>=0; --i, --j) {
            if(board[i][j])
                return false;
        }
        //Check lower left diagonal
        for(int i = row, j = col; i<n && j>=0; ++i, --j) {
            if(board[i][j])
                return false;
        }
        return true;
    }

    public static void countPlacingQueens(boolean[][] board, int column, int placedCount) {
        if(placedCount == k) {
            countWays++;
            return;
        }
        
        if(column == m) return;
        for(int i=0;i<n;i++) {
            if(tryPlacing(board, i, column)) {
                board[i][column] = true;
                countPlacingQueens(board, column+1, placedCount+1);
                board[i][column] = false;
            }
        }
        countPlacingQueens(board, column+1, placedCount);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        boolean[][] board = new boolean[n][m];
        countPlacingQueens(board, 0, 0);
        System.out.println(countWays);
    }
}
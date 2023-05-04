import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangingAString {
    public static void solution(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        List<String> operations = new ArrayList<String>();
        
        for (int i = 0; i <= t.length(); i++) {
            dp[0][i] = i;
        }
        
        for (int j = 0; j <= s.length(); j++) {
            dp[j][0] = j;
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                int cost = (s.charAt(i-1) == t.charAt(j-1)) ? 0 : 1;
                dp[i][j] = Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1]+1), dp[i-1][j-1]+cost);
            }
        }
        
        System.out.println(dp[s.length()][t.length()]);
        
        printer(s.length(), t.length(), dp, s, t);
    }
    
    public static void printer(int x, int y, int[][] dp, String s, String t) {
        if (x <= 0 && y <= 0) {
            return;
        }
        
        if (dp[x-1][y]+1 == dp[x][y] && x > 0) {
            System.out.println("DELETE " + x);
            printer(x-1, y, dp, s, t);
        } else if (dp[x][y-1]+1 == dp[x][y] && y > 0) {
            System.out.println("INSERT " + (x+1) + " " + t.charAt(y-1));
            printer(x, y-1, dp, s, t);
        } else {
            if (s.charAt(x-1) != t.charAt(y-1)) {
                System.out.println("REPLACE " + x + " " + t.charAt(y-1));
            }
            printer(x-1, y-1, dp, s, t);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        solution(s, t);
    }
    
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDistance {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        String s = br.readLine(), t = br.readLine();
        int m = s.length(), n = t.length();
        int[][] edit = new int[m+1][n+1];
        for(int j=0;j<=n;j++)
            edit[0][j] = j;
        for(int i=1;i<=m;i++) {
            edit[i][0] = i;
            for(int j=1;j<=n;j++) {
                int replaceCost = s.charAt(i-1) == t.charAt(j-1)? edit[i-1][j-1] : edit[i-1][j-1] + 1;
                edit[i][j] = Math.min(Math.min(replaceCost, edit[i][j-1]+1), edit[i-1][j]+1);
            }
        }
        System.out.println(edit[m][n]);
    }
}

  S A M S U N G
I 1 2 3 4 5 6 7
n 2 2 3 4 5 5 6
t 3 3 3 4 5 6 7
e 4 4 4 4 5 6 7
r 5 5 5 5 5 6 7
n 6 6 6 6 6 5 6
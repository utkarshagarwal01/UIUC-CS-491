import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class StringProblem {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String start = br.readLine();
        String end = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int V = 26;
        int mat[][] = new int[V][V];
        for(int i=0;i<V;i++) {
            for(int j=0;j<V;j++) {
                if(i!=j) {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while(n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i = st.nextToken().charAt(0) - 'a';
            int j = st.nextToken().charAt(0) - 'a';
            int w = Integer.parseInt(st.nextToken());
            mat[i][j] = Math.min(mat[i][j], w);
        }
        if(start.length() != end.length()) {
            System.out.println(-1);
        } else {
            for(int k=0;k<V;k++) {
                for(int i=0;i<V;i++) {
                    for(int j=0;j<V;j++) {
                        if(mat[i][k] != Integer.MAX_VALUE && mat[k][j] != Integer.MAX_VALUE)
                        mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                    }
                }
            }
            n = start.length();
            char[] newString = new char[n];
            long cost = 0; 
            for(int i=0;i<n;i++) {
                char a = start.charAt(i), b = end.charAt(i); 
                if(a == b) {
                    newString[i] = a;
                } else {
                    int minCost = Integer.MAX_VALUE;
                    char minJ = '0';
                    int p = a-'a', q = b-'a';
                    for(int j=0;j<V;j++) {
                        if(mat[p][j] != Integer.MAX_VALUE && mat[q][j] != Integer.MAX_VALUE && mat[p][j] + mat[q][j] < minCost) {
                            minCost = mat[p][j] + mat[q][j];
                            minJ = (char)(j+'a');
                        }
                    }
                    if(minJ == '0') {
                        System.out.println(-1);
                        break;
                    } else {
                        cost += minCost;
                        newString[i] = minJ;
                    }
                }
            }
            if(newString[n-1] != '\u0000') {
                String s = new String(newString);
                System.out.println(cost);
                System.out.println(s);
            }
        }

    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class FibonnaciNumbers {
    static final long IndentityMatrix[][] = {{1,0}, {0,1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        while(t-->0) {
            long n = Long.parseLong(br.readLine());
            long a[][] = {{1,1},{1,0}};
            System.out.println(matrixSquaring(a,n, m)[0][0]);
        }
    }

    static long[][] multiply(long [][] a, long [][] b, int m) {
        long ans[][] = new long[2][2];
        for(int i=0 ;i<2;i++) {
            for(int j=0 ;j<2;j++) {
                for(int k=0 ;k<2;k++) {
                    ans[i][j] = (ans[i][j] + (a[i][k] * b[k][j]))%m;
                }
            }
        }
        return ans;
    }

    static long[][] matrixSquaring(long[][] a, long n, int m) {
        long ans[][] = a;
        long result[][] = IndentityMatrix;
        while(n!=0) {
            boolean lastBitSet = (n&1) == 1? true: false;
            if(lastBitSet)
                result = multiply(result, ans, m);

            ans = multiply(ans, ans, m);
            n >>= 1;
        }
        return result;
    }
}
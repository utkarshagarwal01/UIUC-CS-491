import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class IteratedLinearFunction {
    static final int m = 1000000007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        long n = Long.parseLong(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        long matrix[][] = new long[2][2];
        matrix[0][0] = A;
        matrix[0][1] = B;
        matrix[1][1] = 1;

        long [][] nSquared = matrixSquaring(matrix, n, m);
        System.out.print((nSquared[0][0] * x + nSquared[0][1])%m);
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
        long result[][] = {{1,0}, {0,1}};
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Divisibility {
    static int n, B, x, y;

    public static int twosInThis(int n) {
        int count = 0;
        while(n%2==0) {
            count++;
            n /= 2;
        }
        return count;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t-- > 0) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int a[] = new int[n];
            int twosCount = 0;
            int operations = 0;
            for(int i=1;i<=n;i++) {
                int curr = Integer.parseInt(st.nextToken());
                int currHasthisManyTwos = twosInThis(curr);
                twosCount += currHasthisManyTwos;
                int numExtraTwos = twosInThis(i);
                a[i-1] = numExtraTwos; 
            }
            // for(int i:a) {
            //     System.out.print(i + " ");
            // }
            // System.out.println();
            Arrays.sort(a);
            // for(int i:a) {
            //     System.out.print(i + " ");
            // }
            // System.out.println();
            int i = n-1;
            // System.out.println("TwosCount: " + twosCount);
            while(i>=0 && twosCount<n) {
                twosCount += a[i];
                i--;
                operations++;
            }
            if(twosCount<n) 
                operations = -1;
            out.print(operations+"\n");
        }
        out.flush();
    }
}
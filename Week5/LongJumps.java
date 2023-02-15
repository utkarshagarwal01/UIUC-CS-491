import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
public class LongJumps {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long a[] = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0;i<n;i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=n-1;i>=0;i--) {
                if(a[i] + i + 1 <= n) {
                    a[i] += a[i+(int)a[i]];
                }
            }
            out.print(Arrays.stream(a).max().getAsLong() + "\n");
            // System.out.println();
            // out.print(operations+"\n");
        }
        out.flush();
    }
}
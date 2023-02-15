import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class PrefixSumAddicts {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            long s[] = new long[k];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<k;i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }
            long curr = Long.MAX_VALUE;
            boolean flag = true;
            if(k != 1) {
                for(int i=k-1;i>=1;i--) {
                    if((s[i]-s[i-1]) <= curr) {
                        curr = s[i]-s[i-1];
                    } else {
                        flag = false;
                        // break;
                    }
                }
                if(curr*(n-k+1)<s[0]) {
                    flag = false;
                }
            }
            if(flag) {
                out.print("Yes\n");
            } else {
                out.print("No\n");
            }
        }
        out.flush();
    }
}
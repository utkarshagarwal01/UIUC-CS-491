import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class PoisonedDagger {
    static int n, time[];
    static long h;
    public static boolean canDefeat(long k) {
        long hits = 0;
        for(int i=1;i<n;i++) {
            hits += Math.min((time[i] - time[i-1]), k);
            if(hits>=h)
                return true;
        }
        hits+=k;
        if(hits >= h)
            return true;
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            h = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());
            time = new int[n];
            for(int i=0;i<n;i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }
            long low = 1, high = h, mid;
            while(low<=high) {
                mid = (low+high)/2;
                boolean canDefeatMid = canDefeat(mid);
                if(canDefeatMid && (mid == 1 || !canDefeat(mid-1))) {
                    out.print(mid+"\n");
                    break;
                } else if(!canDefeatMid) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
            // canDefeat(4);
        }
        out.flush();
    }
}
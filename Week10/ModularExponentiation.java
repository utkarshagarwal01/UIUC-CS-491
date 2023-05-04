import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
public class ModularExponentiation {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        while(t-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            HashMap<Integer, Long> memo = new HashMap<>();
            System.out.println(solve(a,b, m, memo));
        }
    }

    static long solve(int a, int b, int m, HashMap<Integer, Long> memo) {
        if(b==1)
            return a;
        if(b==0) {
            return 1;
        }
        if(memo.containsKey(b))
            return memo.get(b);
        int x = 1;
        long ans = a;
        while(2*x<=b) {
            ans = (ans*ans)%m;
            x *= 2;
        }
        ans = (ans*solve(a, b-x, m, memo))%m;
        memo.put(b, ans);
        return ans;
    }
}

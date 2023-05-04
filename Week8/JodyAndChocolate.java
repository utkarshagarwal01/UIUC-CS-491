import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JodyAndChocolate {
    public static long gcd(long a, long b) {
        return a == 0?b: gcd(b%a, a);
    }
    public static long lcm(long a, long b) {
        return (a/gcd(a,b))*b;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long q = Long.parseLong(st.nextToken());
        long ans = 0;
        ans += (n/a) * p;
        ans += (n/b) * q;
        ans -= (n/lcm(a,b)) * Math.min(p,q);
        System.out.println(ans);
    }
}

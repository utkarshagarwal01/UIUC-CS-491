import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DoremyMathClass {
    public static long gcd(long a, long b) {
        return a == 0?b: gcd(b%a, a);
    }
    public static long lcm(long a, long b) {
        return (a/gcd(a,b))*b;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arr[] = new int[n];
            long tmp = 0;
            for(int i=0;i<n;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                tmp = gcd(tmp, arr[i]);
            }
            System.out.println((arr[n-1]/tmp) + ((arr[0] == 0)?1:0));
        }
    }
}

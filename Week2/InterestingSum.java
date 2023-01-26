import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class InterestingSum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(n-- > 0) {
                int x = Integer.parseInt(st.nextToken());
                if(x > max1) {
                    max2 = max1;
                    max1 = x;
                } else if(x > max2) {
                    max2 = x;
                }
                if(x < min1) {
                    min2 = min1;
                    min1 = x;
                } else if(x < min2) {
                    min2 = x;
                }
            }
            System.out.println(max1+max2-min1-min2);
        }
    }
}
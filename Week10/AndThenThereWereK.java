import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class AndThenThereWereK {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0) {  
            int n = Integer.parseInt(br.readLine());
            // if(n==1)
            //     System.out.println(1);
            // else 
                solve(n);
        }
    }

    static void solve(int n) {
        int c=0, x=n;
        while(x!=0) {
            c++;
            x >>= 1;
        }

        int ans = (n&((1<<(c-1))-1)) + 1;
        System.out.println(n-ans);
    }
}

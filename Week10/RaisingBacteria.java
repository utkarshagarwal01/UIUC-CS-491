import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RaisingBacteria {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int c=0;
        while(n!=0) {
            c += n&1;
            n >>= 1;
        }
        System.out.println(c);
    }
}
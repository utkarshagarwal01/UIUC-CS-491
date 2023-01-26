import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IOExplicitCounts {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int add = Integer.parseInt(st.nextToken());
            int sub = Integer.parseInt(st.nextToken());
            int count = 0;
            while(add-- > 0) {
                count += Integer.parseInt(br.readLine());
            }
            while(sub-- > 0) {
                count -= Integer.parseInt(br.readLine());
            }
            System.out.println(count);
        }
    }
}
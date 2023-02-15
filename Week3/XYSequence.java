import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class XYSequence {
    static int n, B, x, y;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            long sum = 0;
            int curr = 0;
            for(int i=1;i<=n;i++) {
                if(curr<=B-x) {
                    curr += x;
                } else {
                    curr -= y;
                }
                sum += curr; 
            }
            out.print(sum+"\n");
        }
        out.flush();
    }
}
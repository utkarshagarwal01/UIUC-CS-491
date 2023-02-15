import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class ConnectedComponents {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int degree[] = new int[n+1];
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            degree[x]++;degree[y]++;
        }
        int ones = 0, twos = 0, star = 0;
        String s = "";
        for(int i=1;i<=n;i++) {
            if(degree[i] == 1) {
                ones++;
            } else if(degree[i] == 2) {
                twos++;
            } else {
                if(star != 0) {
                    s = "unknown";
                    break;
                }
                star = degree[i]; 
            }
        }
        if(s == "") {
            if(ones == 2 && twos == (n-2)) {
                s = "bus";
            } else if(twos == n) {
                s = "ring";
            } else if(ones == n-1 && star == n-1 ) {
                s = "star";
            } else {
                s = "unknown";
            }
        }
        out.print(s + " topology\n");
        out.flush();
    }
}
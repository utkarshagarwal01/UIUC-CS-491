import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class AplusB {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int add = Integer.parseInt(st.nextToken());
            int sub = Integer.parseInt(st.nextToken());
            System.out.println(add+sub);
        }
    }
}
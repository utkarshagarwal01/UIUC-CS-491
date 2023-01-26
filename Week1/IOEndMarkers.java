import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IOEndMarkers {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {        
            StringTokenizer st = new StringTokenizer(br.readLine());
            int add = Integer.parseInt(st.nextToken());
            int sub = Integer.parseInt(st.nextToken());
            if(add == 0 && sub == 0)
                break;
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
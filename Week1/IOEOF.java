import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IOEOF {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line=br.readLine())!=null) {
            StringTokenizer st = new StringTokenizer(line);
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WhereDoITurn {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long xa = Long.parseLong(st.nextToken());
        long ya = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long xb = Long.parseLong(st.nextToken());
        long yb = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long xc = Long.parseLong(st.nextToken());
        long yc = Long.parseLong(st.nextToken());
        
        long v1[] = new long[2];
        long v2[] = new long[2];
        
        v1[0] = xb-xa;
        v1[1] = yb-ya;

        v2[0] = xc-xb;
        v2[1] = yc-yb;

        long product = v1[0] * v2[1] - v1[1] * v2[0];

        if (product == 0) {
            System.out.println("TOWARDS");
        } else if(product < 0 ) {
            System.out.println("RIGHT");
        } else
            System.out.println("LEFT");
    }
}
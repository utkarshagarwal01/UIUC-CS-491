import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HardWay {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int x3 = Integer.parseInt(st.nextToken());
            int y3 = Integer.parseInt(st.nextToken());
            double total = 0;
            if(y1==y2 && y3<y2) {
                total += distance2Points(x1, y1, x2, y2);
            } else if(y1==y3 && y2<y1) {
                total += distance2Points(x3, y3, x1, y1);
            } else if(y3==y2 && y1<y2) {
                total += distance2Points(x2, y2, x3, y3);
            } 
            System.out.println(total);
        }
    }

    public static double distance2Points(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GlebAndPizza {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        int count=0;
        while(n-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int rSausage = Integer.parseInt(st.nextToken());
            double distSausageCenter = distance2Points(x, y, 0, 0);
            double sInnerDist = distSausageCenter-rSausage, sOuterDist = distSausageCenter+rSausage;
            // System.out.println(sInnerDist + " " + sOuterDist);
            if(sInnerDist>=(r-d) && sOuterDist<=r) {
                // System.out.println("YES");
                count++;
            } else {
                // System.out.println("NO");
            }
        }
        System.out.println(count);
    }

    public static double distance2Points(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }
}
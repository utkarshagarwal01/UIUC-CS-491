import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class KillTheMonster {
    public static boolean doesCharacterWin(double health_c, int damage_c, double health_m, int damage_m) {
        return Math.round(Math.ceil(health_m/damage_c)) <= Math.round(Math.ceil(health_c/damage_m));
    } 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            long health_c = Long.parseLong(st.nextToken());
            int damage_c = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            long health_m = Long.parseLong(st.nextToken());
            int damage_m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            long a = Long.parseLong(st.nextToken());

            boolean wins = false; 
            for(int i=0;i<=k;i++) {
                if(doesCharacterWin(a*i + health_c, w*(k-i) + damage_c, health_m, damage_m)) {
                    wins = true;
                    break;
                }
            }
            
            out.print((wins?"YES":"NO") + "\n");
        }
        out.flush();
    }
}
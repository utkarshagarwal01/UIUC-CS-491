import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BasketballExercise {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st1.nextToken()), b = Long.parseLong(st2.nextToken()), c = 0;
        for(int i=1;i<n;i++) {
            int p = Integer.parseInt(st1.nextToken()), q = Integer.parseInt(st2.nextToken());
            long x = Math.max(Math.max(b+p, c + p), p);                
            long y = Math.max(Math.max(a+q, c + q), q);
            long z = Math.max(a, b);
            
            a = x;
            b = y;
            c = z;
        }
        out.print(Math.max(a,b)+"\n");
        out.flush();
    }
}
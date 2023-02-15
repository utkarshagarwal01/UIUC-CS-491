import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Worms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out =new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        int[] worms = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            if(i==0)
               worms[i] = Integer.parseInt(st.nextToken());
            else 
                worms[i] = worms[i-1] + Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        // System.out.println("Took input");
        while(m-->0) {
            int toFind = Integer.parseInt(st.nextToken());
            int low = 1, high = n-1, mid = 1;
            if(toFind>worms[0]) {
                while(low<=high) {
                    // System.out.println(toFind + " " + low + " " + high);
                    mid = (low+high)/2;
                    if(toFind<=worms[mid] && toFind>worms[mid-1]) {
                        mid = mid+1;
                        break;
                    } else if(toFind>worms[mid]) {
                        low = mid+1;
                    } else {
                        high = mid;
                    }
                }
            }
            out.print(mid + "\n");
        }
        out.flush();
    }
}
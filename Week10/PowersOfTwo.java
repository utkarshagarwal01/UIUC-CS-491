import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class PowersOfTwo {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        solve(n,k);
    }

    static int onesInN(int n) {
        int c=0;
        while(n!=0) {
            c += n&1;
            n >>= 1;
        }
        return c;
    }

    static void solve(int n, int k) {
        int onesCount = onesInN(n);
        if(k<onesCount || k>n) {
            System.out.println("NO");
            return;
        } else {
            System.out.println("YES");
        }
        int c=1;
        PriorityQueue<Integer> li = new PriorityQueue<>();
        while(n!=0) {
            int x = (n&1) * c;
            if(x!=0)
                li.add(x);
            c*=2;
            n >>= 1;
        }
        while(true) {
            if(li.size() == k) {
                break;
            }
            int x = li.poll();
            
            if(x == 1) {
                System.out.print(x + " ");
                k--;
            } else {
                li.add(x/2);
                li.add(x/2);
            }
        }
        for(Integer i: li) {
            System.out.print(i + " ");
        }
    }
}

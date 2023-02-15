import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class Groups {
    static int n;
    static int pref[][];

    public static boolean tryDays(int smaller, int larger) {
        int left=0, right = 0, any = 0;
        for(int i=0;i<n;i++) {
            if(pref[i][smaller] == 1 && pref[i][smaller] == 1) {
                any++;
            } else if(pref[i][smaller] == 1) {
                left++;
            } else if(pref[i][larger] == 1) {
                right++;
            }
        }
        return (left+any)>=n/2 && ((left+right+any) == n);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t-- > 0) {
            n = Integer.parseInt(br.readLine());
            pref = new int[n][5];
            int [] dayCounts = new int[5];
            for (int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<5;j++) {
                    pref[i][j] = Integer.parseInt(st.nextToken());
                    dayCounts[j] += pref[i][j]; 
                }
            }
            boolean canDo = false;
            for(int i=0;i<4;i++) {
                for(int j=i+1;j<5;j++) {
                    if(dayCounts[i]<dayCounts[j]) {
                        if(tryDays(i,j)) {
                            canDo = true;
                        }
                    } else {
                        if(tryDays(j,i)) {
                            canDo = true;
                        }
                    }
                }
            }

            

            out.print((canDo ? "YES":"NO") + "\n");
            // for(int j=0;j<5;j++) {
            //     System.out.print(dayCounts[j] + " "); 
            // }
            // System.out.println();
            // System.out.println(max1Pos + " " + max2Pos); 
            // out.print((wins?"YES":"NO") + "\n");
        }
        out.flush();
    }
}
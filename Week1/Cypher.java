import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cypher {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int [] finalPos = new int[n];
            for(int i=0;i<n;i++) {
                finalPos[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                int seqLen = Integer.parseInt(st.nextToken());
                String sequence = st.nextToken();
                for(int j=0;j<seqLen;j++) {
                    if(sequence.charAt(j) == 'D')
                        finalPos[i]++;
                    else
                        finalPos[i]--;
                    if(finalPos[i] == 10) finalPos[i] = 0;
                    if(finalPos[i] == -1) finalPos[i] = 9;
                }
            }
            for(int i=0;i<n;i++) {
                System.out.print(finalPos[i] + " ");
            }
            System.out.println();
        }
    }
}
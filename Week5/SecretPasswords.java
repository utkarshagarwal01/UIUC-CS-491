import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class SecretPasswords {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String [] arr = new String[n];
        while(n-- > 0) {
            arr[n] = br.readLine();
        }
        arr = new HashSet<String>(Arrays.asList(arr)).toArray(new String[0]);
        n = arr.length;
        MinimumSpanningTree graph = new MinimumSpanningTree(26 + n);
        boolean charUsed[] = new boolean[26];
        for(int i=0;i<n;i++) {
            int index = i+26;
            HashSet<Character> charSet = new HashSet<Character>();
            for(char c: arr[i].toCharArray()) {
                charSet.add(c);
            }
            for(int j=0;j<26;j++) {
                if(charSet.contains((char)('a' + j))) {
                    graph.addEdge(j, index);
                    charUsed[j] = true;
                }
            }
        }
        int charNotUsed = 0;
        for(boolean b: charUsed) {
            if(!b) charNotUsed++;
        }
        System.out.print(graph.connectedComponents() - charNotUsed);
    }
}
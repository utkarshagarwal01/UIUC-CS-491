import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Zigzags {
    public static int[][] computeFrequency(int arr[]) {
        int n = arr.length;
        int [][] f = new int[n+1][n];
        for (int i=1;i<=n;i++) {
            for(int j=0;j<n;j++) {
                int add = 0;
                if(arr[j] == i) {
                    add = 1;
                }
                if(j==0) {
                    f[i][j] = add;
                } else
                    f[i][j] = f[i][j-1] + add;
            }
        }
        // for (int i=0;i<=n;i++) {
        //     for(int j=0;j<n;j++) {
        //         System.out.print(f[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return f;
    }

    public static int[][] computePostFrequency(int arr[]) {
        int n = arr.length;
        int [][] f = new int[n+1][n];
        for (int i=1;i<=n;i++) {
            for(int j=n-1;j>=0;j--) {
                int add = 0;
                if(arr[j] == i) {
                    add = 1;
                }
                if(j==n-1) {
                    f[i][j] = add;
                } else
                    f[i][j] = f[i][j+1] + add;
            }
        }
        // for (int i=0;i<=n;i++) {
        //     for(int j=0;j<n;j++) {
        //         System.out.print(f[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return f;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st1;
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st1 = new StringTokenizer(br.readLine());
            int arr[] = new int[n];
            for(int i=0;i<n;i++) {
                arr[i] = Integer.parseInt(st1.nextToken());
            }
            int s = 0;
            for (int i=0;i<3000;i++) {
                for(int j=0;j<3000;j++) {
                    for(int k=0;k<10;k++) {
                        s++;
                    }
                }
            }

            int [][] preFrequency = computeFrequency(arr);
            // System.out.println();
            int [][] frequency = computePostFrequency(arr);
            long count = 0;
            for(int j=1;j<n-2;j++) {
                for(int k=j+1;k<n-1;k++) {
                    count += preFrequency[arr[k]][j-1] * frequency[arr[j]][k+1];
                }
            }
            System.out.println(count);
        }
        // arr = new HashSet<String>(Arrays.asList(arr)).toArray(new String[0]);
        // n = arr.length;
        // ConnectedComponentHelper graph = new ConnectedComponentHelper(26 + n);
        // boolean charUsed[] = new boolean[26];
        // for(int i=0;i<n;i++) {
        //     int index = i+26;
        //     HashSet<Character> charSet = new HashSet<Character>();
        //     for(char c: arr[i].toCharArray()) {
        //         charSet.add(c);
        //     }
        //     for(int j=0;j<26;j++) {
        //         if(charSet.contains((char)('a' + j))) {
        //             graph.addEdge(j, index);
        //             charUsed[j] = true;
        //         }
        //     }
        // }
        // int charNotUsed = 0;
        // for(boolean b: charUsed) {
        //     if(!b) charNotUsed++;
        // }
        // System.out.print(graph.connectedComponents() - charNotUsed);
    }
}
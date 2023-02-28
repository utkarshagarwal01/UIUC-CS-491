import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
public class GregAndGraph {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        int mat[][] = new int[n][n];
        StringTokenizer st;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Integer deleted[] = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            deleted[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> reverseDeleted = Arrays.asList(deleted);
        Collections.reverse(reverseDeleted);
        deleted = reverseDeleted.toArray(new Integer[0]);
        
        LinkedList<Long> stack = new LinkedList<>();

        for(int p=0;p<n;p++) {
            int k = deleted[p]-1;
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
            }
            long sum = 0;
            for(int i=0;i<=p;i++) {
                for(int j=0;j<=p;j++) {
                    sum += mat[deleted[i]-1][deleted[j]-1];
                }
            }
            stack.push(sum);
            // System.out.print(sum + " ");
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        out.flush();
    }
}
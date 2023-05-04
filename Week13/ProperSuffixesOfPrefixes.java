import java.io.PrintWriter;
import java.util.Scanner;

public class ProperSuffixesOfPrefixes {
    public static void KMPSearch(String pat) {
        int M = pat.length();
        PrintWriter out = new PrintWriter(System.out);
        int res = 0;
        int[] lps = new int[M];
        int j = 0;
    
        computeLPSArray(pat, M, lps);

        for(int i: lps) {
            out.write(i + " ");
        }
        out.flush();
    }
    
    public static void computeLPSArray(String pat, int M, int[] lps) {
        int len = 0;
    
        lps[0] = 0;
        int i = 1;
    
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if (len != 0) {
                    len = lps[len-1];
                }
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pat = scanner.nextLine();
        KMPSearch(pat);
    }
    
}
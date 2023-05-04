import java.util.Scanner;

public class StringMatching {
    public static int KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int res = 0;
        int[] lps = new int[M];
        int j = 0;
    
        computeLPSArray(pat, M, lps);
        int i = 0;
        while ((N - i) >= (M - j)) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
    
            if (j == M) {
                res++;
                j = lps[j-1];
            }
    
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j-1];
                }
                else {
                    i++;
                }
            }
        }
        return res;
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
        String txt = scanner.nextLine();
        String pat = scanner.nextLine();
        int ans = KMPSearch(pat, txt);
        System.out.println(ans);
    }
    
}
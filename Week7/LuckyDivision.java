import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
public class LuckyDivision {
    public static void main(String[] args) throws IOException{
        LuckyDivision obj = new LuckyDivision();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.print(obj.findFactors(n));
    }

    public boolean isOnly47(int f) {
        while(f!=0) {
            int a = f%10;
            if(a!=4 && a!=7) 
                return false;
            f /= 10;
        }
        return true;
    }

    public String findFactors(int num) {        
        ArrayList<Integer> factors = new ArrayList<Integer>();
    
        // Skip two if the number is odd
        int incrementer = num % 2 == 0 ? 1 : 2;
    
        for (int i = 1; i <= Math.sqrt(num); i += incrementer) {
    
            // If there is no remainder, then the number is a factor.
            if (num % i == 0) {
                factors.add(i);
                if(isOnly47(i)) return "YES";
    
                // Skip duplicates
                if (i != num / i) {
                    factors.add(num / i);
                    if(isOnly47(num / i)) return "YES";
                }
    
            }
        }
    
        // Sort the list of factors
        // Collections.sort(factors);
    
        return "NO";
    }
}
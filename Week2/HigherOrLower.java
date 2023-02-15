import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HigherOrLower {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long low = 1, high = 1000000000000000000L;
        long mid;
        while(low<=high) {
            mid = (low+high)/2;
            System.out.println(mid);
            String s = br.readLine();
            if(s.equals("CORRECT")) {
                break;
            } else if(s.equals("LOWER")) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
    }
}
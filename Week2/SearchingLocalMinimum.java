import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchingLocalMinimum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int low = 1, high = n, mid, midLeft, midRight, a, b, c;
        while(low<=high) {
            mid = (low+high)/2;
            // System.out.println("Low = " + low + " Mid = " + mid + " High = " + high);
            System.out.println("? " + mid);
            b = Integer.parseInt(br.readLine());
            midLeft = mid-1;
            midRight = mid+1;
            if(midLeft != 0) {
                System.out.println("? " + midLeft);
                a = Integer.parseInt(br.readLine());
            } else 
                a = Integer.MAX_VALUE;  
            if(midRight != n+1) {
                System.out.println("? " + midRight);
                c = Integer.parseInt(br.readLine());
            } else 
                c = Integer.MAX_VALUE;  
            
            if(a<b) {
                high = mid;
            } else if(c<b) {
                low = midRight;
            } else {
                System.out.print("! " + mid);
                break;
            }
        }
    }
}
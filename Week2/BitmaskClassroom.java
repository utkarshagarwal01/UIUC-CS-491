import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitmaskClassroom {
    public static int getRightmost1Position(int x) {
        int c = 0;
        while((x & 1) == 0) {
            c++;
            x = x >> 1;
        }
        return c;
    }

    public static int getRightmost0Position(int x) {
        int c = 0;
        while((x & 1) == 1) {
            c++;
            x = x >> 1;
        }
        return c;
    }

    public static int getSecondRightmost1Position(int x) {
        int rightmost1Pos = getRightmost1Position(x);
        x = x >> (rightmost1Pos + 1);
        if(x == 0) return -1;
        int secondRightmost = rightmost1Pos + 1;
        while((x > 0) && (x & 1) == 0) {
            secondRightmost++;
            x = x >> 1;
        }
        return secondRightmost;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            int rightMost1 = getRightmost1Position(x);
            int secondRightmost1 = getSecondRightmost1Position(x);
            int rightMost0 = getRightmost0Position(x);
            if(secondRightmost1 == -1) {
                System.out.println((1 << rightMost1) | ( 1 << rightMost0));
            } else 
                System.out.println(1 << rightMost1);
        }
    }
}
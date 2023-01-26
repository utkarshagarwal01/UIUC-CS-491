import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;

public class Thor {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out =new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        ArrayList<LinkedList<Integer>> unreadApps = new ArrayList<LinkedList<Integer>>(n+1);
        while(n-- > -1) {
            unreadApps.add(new LinkedList<Integer>());
        }
        int[] notif = new int[q];
        int i = 0;
        int sum = 0;
        int readTill = 0;
        while(q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if(type == 1) {
                unreadApps.get(x).add(i);
                sum++;
                notif[i++] = x;
            } else if(type == 2) {
                sum -= unreadApps.get(x).size();
                unreadApps.set(x, new LinkedList<>());
            } else if(type == 3) {
                if(x > readTill) {
                    for(int j=readTill; j<x;j++) {
                        LinkedList<Integer> currentAppQueue = unreadApps.get(notif[j]);
                        if(currentAppQueue.size() !=0 && currentAppQueue.peek() <= j) {
                            currentAppQueue.remove();
                            sum--;
                        }
                    }
                    readTill = x;
                }
            }
            out.print(sum + "\n");
        }
        out.flush();
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class MinimizeDistance {
    public static long calculateDistance(List<Integer> list, int k, PrintWriter out) {
        long distance = 0;
        if(list.size() == 0) return distance;
        int skip = list.size()%k;
        ListIterator<Integer> it = list.listIterator(skip);
        if(skip>0)
            distance += 2*list.get(skip-1); 
        int x = 1, curr = 0;
        while(it.hasNext()) {
            curr = it.next();
            if((x++)%k==0)
                distance += 2*curr;
        }
        return distance;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<n;i++) {
                int x = Integer.parseInt(st.nextToken());
                if(x != 0)  list.add(x);
            }
            list.add(0);list.sort(null);
            int zeroIndex = list.indexOf(0);
            List<Integer> l1 = list.subList(zeroIndex+1, list.size());
            List<Integer> l2 = list.subList(0, zeroIndex);
            Collections.reverse(l2);
            for(int i=0;i<l2.size();i++) {
                l2.set(i, Math.abs(l2.get(i)));
            }
            long distance = calculateDistance(l1, k, out) + calculateDistance(l2, k, out);
            int l1s = l1.size(), l2s = l2.size();
            if(l1s == 0 && l2s ==0 ) {
                //nothing;
            } else if(l1s == 0 || (l2s != 0 && l1.get(l1s-1) < l2.get(l2s-1) )) {
                distance -= l2.get(l2s-1);
            } else {
                distance -= l1.get(l1s-1);
            } 
            out.print(distance+"\n");
        }
        out.flush();
    }
}
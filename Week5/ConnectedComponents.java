import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class ConnectedComponents {
    static TreeSet<Integer> unvisitedVertices = new TreeSet<>();
    static HashMap<Integer, HashSet<Integer>> notAdjList = new HashMap<>();

    public static void addEdge(int x, int y) {
        if(notAdjList.containsKey(x)) {
            notAdjList.get(x).add(y);
        } else {
            HashSet <Integer> newSet = new HashSet<>();
            newSet.add(y);
            notAdjList.put(x, newSet);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        for(int i=1;i<=n;i++) {
            unvisitedVertices.add(i);
        }
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            addEdge(x, y);
            addEdge(y, x);
        }
        ArrayList<Integer> sizes = new ArrayList<>();
        int currentSize = n;
        while(currentSize != 0) {
            int i = unvisitedVertices.first();
            dfs(i);
            sizes.add(currentSize - unvisitedVertices.size());
            currentSize = unvisitedVertices.size();
        }
        Collections.sort(sizes);
        System.out.println(sizes.size());
        for(int i: sizes) {
            System.out.print(i + " ");
        }
    }
    public static void dfs(int i) {
        unvisitedVertices.remove(i);
        int k = 0;
        Integer curr;
        while((curr = unvisitedVertices.higher(k)) != null) {
            if(notAdjList.get(i) == null || !notAdjList.get(i).contains(curr)) {
                dfs(curr);
            }
            k = curr;
        }
    }
}
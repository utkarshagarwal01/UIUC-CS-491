import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
public class Checkposts {
    ArrayList<HashSet<Integer>> adjList, transpose;
    int V;
    boolean[] visited;
    LinkedList<Integer> stack;
    int[] componentNumber;

    public void createGraph(int V, Integer[][] edges) {
        adjList = new ArrayList<>();
        this.V = V;
        for(int i=0;i<V;i++)
            adjList.add(new HashSet<>());
        for(int i=0;i<edges.length;i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
        }
    }
    public ArrayList<HashSet<Integer>> getTranspose() {
        ArrayList<HashSet<Integer>> reversed = new ArrayList<>();
        for(int i=0;i<V;i++)
            reversed.add(new HashSet<>());
        for(int i=0;i<V;i++) {
            for(int j: adjList.get(i))
                reversed.get(j).add(i);
        }
        return reversed;
    }
    void DFSUtil(int v, int marker, boolean onTranspose)
    {
        visited[v] = true;
        if(marker > 0) {
            componentNumber[v] = marker;
        }
        ArrayList<HashSet<Integer>> graph = onTranspose?transpose:adjList;
        for (int x : graph.get(v)) {
            if (!visited[x]) {
                // System.out.println("Travelling from " + (v+1) + " to " + (x+1));
                DFSUtil(x, marker, onTranspose);
            }
        }
        if(marker ==  0) {
            // System.out.println(v+1);
            stack.push(v);
        }
    }
    public void dfs()
    {
        for (int v = 0; v < V; ++v) {
            if (!visited[v]) {
                DFSUtil(v, 0, false);
            }
        }
    }

    public void kosarajuSCC(int[] costs) {
        stack = new LinkedList<>();
        visited = new boolean[V];
        dfs();

        visited = new boolean[V];
        componentNumber = new int[V];
        int marker = 1;
        while(!stack.isEmpty()) {
            int v = stack.pop();
            if(!visited[v]) {
                DFSUtil(v, marker, true);
            }
            marker++;
        }
        HashMap<Integer, Integer> money = new HashMap<>(); 
        HashMap<Integer, Integer> size = new HashMap<>(); 
        for(int i=0;i<V;i++) {
            int comp = componentNumber[i];
            if(money.containsKey(comp)) {
                int currMoney = money.get(comp);
                if(costs[i] < currMoney) {
                    money.put(comp, costs[i]);
                    size.put(comp, 1);
                } else if(costs[i] == currMoney){
                    size.put(comp, size.get(comp)+1);
                }
            } else {
                money.put(comp, costs[i]);
                size.put(comp, 1);
            }
            // System.out.print(i + " ");
        }
        long ways = 1;
        long sum = 0;
        for(Map.Entry<Integer,Integer> entry: money.entrySet()) {
            int comp = entry.getKey();
            sum += money.get(comp);
            ways = (ways*size.get(comp))% 1000000007;
        }
        System.out.println(sum + " " + ways);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int costs[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        Integer edges[][] = new Integer[m][2];
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken())-1;
            edges[i][1] = Integer.parseInt(st.nextToken())-1;
        }
        Checkposts obj = new Checkposts();
        obj.createGraph(n, edges);
        obj.transpose = obj.getTranspose();
        obj.kosarajuSCC(costs);
        
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.HashMap;
public class NewsDistribution {
    
    int V;
    boolean[] visited;
    ArrayList<HashSet<Integer>> adjList;
    int componentNumber[];

    void DFSUtil(int v, int marker)
    {
        visited[v] = true;
        componentNumber[v] = marker;
        for (int x : adjList.get(v)) {
            if (!visited[x]) {
                DFSUtil(x, marker);
            }
        }
    }
    public void dfs()
    {
        int marker = 0;
        for (int v = 0; v < V; ++v) {
            if (!visited[v]) {
                DFSUtil(v, marker);
            }
            marker++;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<HashSet<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)
        adjList.add(new HashSet<>());
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            if(size < 2) continue;
            int first = Integer.parseInt(st.nextToken())-1;
            int first_copy = first;
            for(int j=1;j<size;j++) {
                int v = Integer.parseInt(st.nextToken())-1;
                adjList.get(first).add(v);
                first = v;
            }
            adjList.get(first).add(first_copy);
        }
        NewsDistribution obj = new NewsDistribution();
        obj.adjList = adjList;
        obj.V = n;
        obj.visited = new boolean[n];
        obj.componentNumber = new int[n];
        obj.dfs();

        HashMap<Integer, Integer> sizes = new HashMap<>();
        for(int i=0;i<n;i++) {
            int comp = obj.componentNumber[i];
            if(sizes.containsKey(comp)) {
                sizes.put(comp, sizes.get(comp) +1);
            } else {
                sizes.put(comp, 1);
            }
        }
        for(int i=0;i<n;i++) {
            out.print(sizes.get(obj.componentNumber[i]) + " ");
        }
        out.flush();
    }
}
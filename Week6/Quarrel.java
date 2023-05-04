import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Comparator;
public class Quarrel {
    ArrayList<HashSet<Node>> adjList;
    int V;
    boolean[] visited;

    public void createGraph(int V, Integer[][] edges) {
        adjList = new ArrayList<>();
        this.V = V;
        for(int i=0;i<V;i++)
            adjList.add(new HashSet<>());
        for(int i=0;i<edges.length;i++) {
            adjList.get(edges[i][0]).add(new Node(edges[i][1], edges[i][2]));
        }
    }
    void DFSUtil(int v, int color)
    {
        // System.out.println(v+1);
        visited[v] = true;
        for (Node x : adjList.get(v)) {
            if (x.weight == color && !visited[x.dest]) {
                DFSUtil(x.dest, color);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Integer edges[][] = new Integer[2*m][3];
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken())-1;
            edges[i][1] = Integer.parseInt(st.nextToken())-1;
            // edges[i][2] = Integer.parseInt(st.nextToken());

            edges[m+i][0] = edges[i][1];
            edges[m+i][1] = edges[i][0];
            // edges[m+i][2] = edges[i][2];
        }
        MrKitayutasColorfulGraph obj = new MrKitayutasColorfulGraph();
        obj.createGraph(n, edges);
        int q = Integer.parseInt(br.readLine());
        while(q-->0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            int count = 0;
            for(int c=1;c<=m;c++) {
                // System.out.println("Color: " + c);
                obj.visited = new boolean[n];
                obj.DFSUtil(u, c);
                if(obj.visited[v])
                    count++;
            }
            System.out.println(count);

        }
        
    }
}

class Node implements Comparator<Node> {
    int dest;
    long weight;
    public Node() {}
    public Node(int dest, long weight) {
        this.dest = dest;
        this.weight = weight;
    }
    @Override 
    public int compare(Node n1, Node n2) {
        if(n1.weight<n2.weight)
            return -1;
        else if(n1.weight>n2.weight)
            return 1;
        return 0;
    }
}
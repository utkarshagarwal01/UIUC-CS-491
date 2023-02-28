import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.ArrayList;
public class CommuteConundrum {
    public ArrayList<HashSet<Node>> createGraph(int V, int k, int t, Integer[][] edges) throws IOException{
        ArrayList<HashSet<Node>> adjList = new ArrayList<>(k*V+1);
        for(int i=0;i<k*V;i++)
            adjList.add(new HashSet<>());
        for(int j=0;j<k;j++) {
            for(int i=0;i<edges.length;i++) {
                adjList.get(V*j + edges[i][0]).add(new Node(V*j + edges[i][1], edges[i][2]));
                if(j!=k-1) {
                    adjList.get(V*j + edges[i][0]).add(new Node(V*(j+1) + edges[i][1], 0));
                }
            }
        }
        adjList.add(new HashSet<>());
        for(int j=0;j<k;j++) {
            adjList.get(V*j + t).add(new Node(V*k, 0));
        }
        return adjList;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken())+1;
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken())-1;
        int t = Integer.parseInt(st.nextToken())-1;
        Integer edges[][] = new Integer[2*m][3];
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken())-1;
            edges[i][1] = Integer.parseInt(st.nextToken())-1;
            edges[i][2] = Integer.parseInt(st.nextToken());
            edges[i+m][0] = edges[i][1];
            edges[i+m][1] = edges[i][0];
            edges[i+m][2] = edges[i][2];
        }
        CommuteConundrum obj = new CommuteConundrum();
        ArrayList<HashSet<Node>> adjList = obj.createGraph(n, k, t, edges);
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>(n*k+1, new Node());
        HashSet<Integer> visited = new HashSet<>(n*k+1);
        long[] distance = new long[n*k+1];
        for(int i=0;i<n*k+1;i++) {
            distance[i] = Long.MAX_VALUE;
        }
        distance[s] = 0;
        pq.add(new Node(s, 0));
        while(!pq.isEmpty()) {
            int u = pq.poll().dest;
            if(visited.contains(u))
                continue;
            if(u == (n*k))
                break;
            visited.add(u);
            for(Node connections: adjList.get(u)) {
                int v = connections.dest;
                long w = connections.weight;
                if(!visited.contains(v)) {
                    if(distance[v] > distance[u] + w) {
                        distance[v] = distance[u] + w;
                        pq.add(new Node(v, distance[v]));
                    }
                }
            }
        }
        System.out.print(distance[n*k]);
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
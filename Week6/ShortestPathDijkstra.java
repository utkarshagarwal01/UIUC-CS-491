import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.Map;
import java.util.ArrayList;
public class ShortestPathDijkstra {

    public Integer[][] removeDuplicateEdges(Integer [][]edges) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<edges.length;i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            if(u == v) continue;
            if(!map.containsKey(u))
                map.put(u, new HashMap<>());
            HashMap<Integer, Integer> edgeMap = map.get(u);
            if(!edgeMap.containsKey(v)) {
                edgeMap.put(v, w);
                count++;
            } else {
                int weight = edgeMap.get(v);
                if(weight>w) {
                    edgeMap.put(v, w);
                }
            }
        }
        Integer[][] returnArray = new Integer[count][3];
        int i=0;
        for(Map.Entry<Integer, HashMap<Integer, Integer>> entry: map.entrySet()) {
            int u = entry.getKey();
            HashMap<Integer, Integer> e = entry.getValue();
            for(Map.Entry<Integer, Integer> entry2: e.entrySet()) {
                int v = entry2.getKey();
                int w = entry2.getValue();
                returnArray[i][0] = u;
                returnArray[i][1] = v;
                returnArray[i][2] = w;
                i++;
            }
        }
        return returnArray;
    }

    public ArrayList<HashSet<Node>> createGraph(int V, Integer[][] edges) {
        edges = removeDuplicateEdges(edges);
        ArrayList<HashSet<Node>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++)
            adjList.add(new HashSet<>());
        for(int i=0;i<edges.length;i++) {
            adjList.get(edges[i][0]).add(new Node(edges[i][1], edges[i][2]));
        }
        return adjList;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(br.readLine()) - 1;
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
        ShortestPathDijkstra obj = new ShortestPathDijkstra();
        ArrayList<HashSet<Node>> adjList = obj.createGraph(n, edges);
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>(n, new Node());
        HashSet<Integer> visited = new HashSet<>();
        long[] distance = new long[n];
        for(int i=0;i<n;i++) {
            distance[i] = Long.MAX_VALUE;
        }
        distance[s] = 0;
        pq.offer(new Node(s, 0));
        while(!pq.isEmpty()) {
            int u = pq.poll().dest;
            if(visited.contains(u))
                continue;
            visited.add(u);
            for(Node connections: adjList.get(u)) {
                int v = connections.dest;
                long w = connections.weight;
                if(!visited.contains(v)) {
                    if(distance[u] != Long.MAX_VALUE && distance[v] > distance[u] + w) {
                        distance[v] = distance[u] + w;
                        pq.add(new Node(v, distance[v]));
                    }
                }
            }
        }
        for(Long d: distance) {
            System.out.print((d == Long.MAX_VALUE?-1:d) + " ");
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
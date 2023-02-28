import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class CowAndSnacks {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ConnectedComponentHelper g = new ConnectedComponentHelper(n);
        int i=0;
        while(i++<k) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            g.addEdge(x-1, y-1);
        }
        System.out.print(k-n+g.connectedComponents());
    }
}

class ConnectedComponentHelper {
    // A user define class to represent a graph.
    // A graph is an array of adjacency lists.
    // Size of array will be V (number of vertices
    // in graph)
    int V;
    ArrayList<ArrayList<Integer> > adjListArray;
 
    // constructor
    ConnectedComponentHelper(int V)
    {
        this.V = V;
        // define the size of array as
        // number of vertices
        adjListArray = new ArrayList<>();
 
        // Create a new list for each vertex
        // such that adjacent nodes can be stored
 
        for (int i = 0; i < V; i++) {
            adjListArray.add(i, new ArrayList<>());
        }
    }
 
    // Adds an edge to an undirected graph
    void addEdge(int src, int dest)
    {
        // Add an edge from src to dest.
        adjListArray.get(src).add(dest);
 
        // Since graph is undirected, add an edge from dest
        // to src also
        adjListArray.get(dest).add(src);
    }
 
    void DFSUtil(int v, boolean[] visited)
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        // System.out.print(v + " ");
        // Recur for all the vertices
        // adjacent to this vertex
        for (int x : adjListArray.get(v)) {
            if (!visited[x])
                DFSUtil(x, visited);
        }
    }
    int connectedComponents()
    {
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int v = 0; v < V; ++v) {
            if (!visited[v]) {
                count++;
                // print all reachable vertices
                // from v
                DFSUtil(v, visited);
                // System.out.println();
            }
        }
        return count;
    }
}
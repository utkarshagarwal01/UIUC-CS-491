import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.ArrayList;
public class AbstractArt {
    public ArrayList<HashSet<Integer>> createGraph(int V, Integer[][] edges) {
        ArrayList<HashSet<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++)
            adjList.add(new HashSet<>());
        for(int i=0;i<edges.length;i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
        }
        return adjList;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Integer edges[][] = new Integer[m][2];
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken())-1;
            edges[i][1] = Integer.parseInt(st.nextToken())-1;
        }
        AbstractArt obj = new AbstractArt();
        ArrayList<HashSet<Integer>> adjList = obj.createGraph(n, edges);
        
        HashSet<Integer> stack = new HashSet<>();
        ArrayList<Integer> postOrder = new ArrayList<>();
        boolean[] visited = new boolean[n];
        
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                obj.topologicalSort(adjList, i, stack, visited, postOrder);
            }
        }
        int size = postOrder.size();
        for(int i=size-1;i>=0;i--)
            System.out.print(postOrder.get(i) + 1  + " ");
    }

    public void topologicalSort(ArrayList<HashSet<Integer>> adjList, int root, HashSet<Integer> stack, boolean[] visited, ArrayList<Integer> postOrder) {
        if(stack.contains(root)) {
            System.out.println(-1);
            System.exit(0);
        }
        if(visited[root]) return;
        visited[root] = true;
        stack.add(root);
        for(Integer child: adjList.get(root))
            topologicalSort(adjList, child, stack, visited, postOrder);
        stack.remove(root);
        postOrder.add(root);
    }
}
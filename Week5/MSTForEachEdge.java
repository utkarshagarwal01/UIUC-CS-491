import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
public class MSTForEachEdge {

    // Java implementation to find the
// maximum weighted edge in the simple
// path between two nodes in N-ary Tree
    static int N = 200005;
     
    // Depths of Nodes
    static int[] level = new int[N];
    static int LG = 20;
   
    // Parent at every 2^i level
    static int[][] dp = new int[LG][N];
   
    // Maximum node at every 2^i level
    static int[][] mx = new int[LG][N];
   
    // Graph that stores destinations
    // and its weight
    static Vector<Vector<Point>> v = new Vector<Vector<Point>>();
      
    static int n = 0;
   
    // Function to traverse the
    // nodes using the Depth-First
    // Search Traversal
    static void dfs_lca(int a, int par, int lev)
    {
        dp[0][a] = par;
        level[a] = lev;
        for(int i = 0; i < v.get(a).size(); i++)
        {
            // Condition to check
            // if its equal to its
            // parent then skip
            if (v.get(a).get(i).x == par)
                continue;
            mx[0][v.get(a).get(i).x] = v.get(a).get(i).y;
   
            // DFS Recursive Call
            dfs_lca(v.get(a).get(i).x, a, lev + 1);
        }
    }
   
    // Function to find the ancestor
    static void find_ancestor()
    {
        // Loop to set every 2^i distance
        for(int i = 1; i < 16; i++)
        {
            // Loop to calculate for
            // each node in the N-ary tree
            for(int j = 1; j < n + 1; j++)
            {
                dp[i][j] = dp[i - 1][dp[i - 1][j]];
   
                // Storing maximum edge
                mx[i][j] = Math.max(mx[i - 1][j], mx[i - 1][dp[i - 1][j]]);
            }
        }
    }
   
    static int getMax(int a, int b)
    {
        // Swapping if node a is at more depth
        // than node b because we will
        // always take at more depth
        if (level[b] < level[a])
        {
            int temp = a;
            a = b;
            b = temp;
        }
   
        int ans = 0;
   
        // Difference between the
        // depth of the two given
        // nodes
        int diff = level[b] - level[a];
   
        while (diff > 0)
        {
            int log = (int)(Math.log(diff) / Math.log(2));
            ans = Math.max(ans, mx[log][b]);
   
            // Changing Node B to its
            // parent at 2 ^ i distance
            b = dp[log][b];
   
            // Subtracting distance by 2^i
            diff -= (1 << log);
        }
   
        // Take both a, b to its
        // lca and find maximum
        while (a != b)
        {
            int i = (int)(Math.log(level[a]) / Math.log(2));
   
            // Loop to find the maximum 2^ith
            // parent the is different
            // for both a and b
            while (i > 0 && dp[i][a] == dp[i][b])
            {
                i-=1;
            }
   
            // Updating ans
            ans = Math.max(ans, mx[i][a]);
            ans = Math.max(ans, mx[i][b]);
   
            // Changing value to
            // its parent
            a = dp[i][a];
            b = dp[i][b];
        }
   
        return ans;
    }
   
    // Function to compute the Least
    // common Ancestor
    static void compute_lca()
    {
        dfs_lca(1, 0, 0);
        find_ancestor();
    }
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        MinimumSpanningTree obj = new MinimumSpanningTree(n);
        PrintWriter out = new PrintWriter(System.out);
        int edges[][] = new int[m][2];
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());
            edges[m][0] = x;
            edges[m][1] = y;
            obj.addEdge(x, y, z);
        }

        obj.kruskals();

        for(int i = 0; i < LG; i++)
        {
            for(int j = 0; j < N; j++)
            {
                dp[i][j] = 0;
                mx[i][j] = 0;
            }
        }
        for(int i = 0; i < N; i++)
        {
            v.add(new Vector<Point>());
        }
        long weight = 0;
        
        for(Map.Entry<Integer, HashSet<Point>> entry: obj.resultMST.entrySet()) {
            int x = entry.getKey();
            for(Point p: entry.getValue()) {
                v.get(x).add(p);
            }
        }
        
        // Computing LCA
        compute_lca();
       
        for (int i = 0; i < m; i++) {
            int max_edge = getMax(edges[i][0],
                                  edges[i][1]);
            System.out.println(max_edge);
        }
    }
}
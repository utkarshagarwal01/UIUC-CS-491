
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class MinimumSpanningTree {
    int V;
    List<Edge> graphEdges = new ArrayList<Edge>();
    HashMap<Integer, HashSet<Point>> resultMST = new HashMap<>();
    public MinimumSpanningTree(int V) {
        this.V = V;
    }

    public void addEdge(int src, int dest, int w) {
        graphEdges.add(new Edge(src, dest, w));
    }

    public void addEdgeToMST(int src, int dest, int w) {
        Point n = new Point(dest, w);
        if(resultMST.get(src) == null) {
            HashSet<Point> newSet = new HashSet<>();
            newSet.add(n);
            resultMST.put(src, newSet);
        } else {
            resultMST.get(src).add(n);
        }
    }

    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Subset {
        int parent, rank;

        public Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    // Starting point of program execution
    public static void main(String[] args) {
        /*****************************************
         * Let us create following weighted graph
         * 10
         * 0--------1
         * | - |
         * 6| 5- |15
         * | - |
         * 2--------3
         * 4
         *****************************************/
        int V = 4;
        MinimumSpanningTree obj = new MinimumSpanningTree(V);
        obj.addEdge(0, 1, 10);
        obj.addEdge(0, 2, 6);
        obj.addEdge(0, 3, 5);
        obj.addEdge(1, 3, 15);
        obj.addEdge(2, 3, 4);

        obj.kruskals();
        // Step 1: sort the edges in non-decreasing order
        // (increasing with repetition allowed)
        for(Map.Entry<Integer, HashSet<Point>> entry: obj.resultMST.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for(Point x: entry.getValue()) {
                // System.out.print(x.x + " ");
            }
            // System.out.println();
        }
    }

    public void kruskals() {
        graphEdges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        int j = 0;
        int noOfEdges = 0;
        // Allocate memory for creating V subsets
        Subset subsets[] = new Subset[V];

        // Allocate memory for results
        Edge results[] = new Edge[V];

        // Create V subsets with single elements
        for (int i = 0; i < V; i++) {
            subsets[i] = new Subset(i, 0);
        }

        // Number of edges to be taken is equal to V-1
        while (noOfEdges < V - 1) {
            // Step 2: Pick the smallest edge. And increment
            // the index for next iteration
            Edge nextEdge = graphEdges.get(j);
            int x = findRoot(subsets, nextEdge.src);
            int y = findRoot(subsets, nextEdge.dest);

            // If including this edge doesn't cause cycle,
            // include it in result and increment the index
            // of result for next edge
            if (x != y) {
                results[noOfEdges] = nextEdge;
                union(subsets, x, y);
                noOfEdges++;
            }

            j++;
        }

        
        // print the contents of result[] to display the built MST
        for (int i = 0; i < noOfEdges; i++) {
            addEdgeToMST(results[i].src, results[i].dest, results[i].weight);
            addEdgeToMST(results[i].dest, results[i].src, results[i].weight);
        }
    }

    private static void union(Subset[] subsets, int x, int y) {
        int rootX = findRoot(subsets, x);
        int rootY = findRoot(subsets, y);

        if (subsets[rootY].rank < subsets[rootX].rank) {
            subsets[rootY].parent = rootX;
        } else if (subsets[rootX].rank < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        } else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    private static int findRoot(Subset[] subsets, int i) {
        if (subsets[i].parent == i)
            return subsets[i].parent;

        subsets[i].parent = findRoot(subsets, subsets[i].parent);
        return subsets[i].parent;
    }
}
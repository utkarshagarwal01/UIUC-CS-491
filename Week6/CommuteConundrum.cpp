#include <iostream>
#include <cstdio>
#include <queue>
#include <vector>
#include <set>
using namespace std;

class Node {
public:
    int dest;
    long long weight;
    Node() {}
    Node(int dest, long long weight) {
        this->dest = dest;
        this->weight = weight;
    }
};

class CompareNode {
public:
    bool operator()(Node const& n1, Node const& n2) {
        long long t = n1.weight - n2.weight;
        if (t == 0) return false;
        if (t < 0) return true;
        return false;
    }
};

class CommuteConundrum {
public:
    vector<set<Node>> createGraph(int V, int k, int t, vector<vector<int>> edges) {
        vector<set<Node>> adjList(k * V + 1);
        for (int i = 0; i < k * V; i++)
            adjList[i].clear();
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < edges.size(); i++) {
                adjList[V * j + edges[i][0]].insert(Node(V * j + edges[i][1], edges[i][2]));
                if (j != k - 1) {
                    adjList[V * j + edges[i][0]].insert(Node(V * (j + 1) + edges[i][1], 0));
                }
            }
        }
        adjList[k * V].clear();
        for (int j = 0; j < k; j++) {
            adjList[V * j + t].insert(Node(k * V, 0));
        }
        return adjList;
    }
    void solve() {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);

        int n, m, k;
        cin >> n >> m >> k;
        k++;
        int s, t;
        cin >> s >> t;
        s--; t--;
        vector<vector<int>> edges(m, vector<int>(3));
        for (int i = 0; i < m; i++) {
            cin >> edges[i][0] >> edges[i][1] >> edges[i][2];
            edges[i][0]--; edges[i][1]--;
            edges[i + m][0] = edges[i][1];
            edges[i + m][1] = edges[i][0];
            edges[i + m][2] = edges[i][2];
        }
        CommuteConundrum obj;
        vector<set<Node>> adjList = obj.createGraph(n, k, t, edges);
        priority_queue<Node, vector<Node>, CompareNode> pq;
        set<int> visited;
        long long distance[n * k + 1];
        for (int i = 0; i <= n * k; i++) {
            distance[i] = 1e18;
        }
        distance[s] = 0;
        pq.push(Node(s, 0));
        while (!pq.empty()) {
            int u = pq.top().dest;
            pq.pop();
            if (visited.count(u)) continue;
            if (u == (n * k)) break;
            visited.insert(u);
            for (auto connections : adjList[u]) {
                int v = connections.dest;
                long long w = connections.weight;
                if (!visited.count(v)) {
                    if (distance[v] > distance[u] + w) {
                        distance[v] = distance[u] + w;
                        pq.push(Node(v, distance[v]));
                    }
                }
            }
        }
        cout << distance[n*k];
    }
}
               

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class BiridianForest {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int INF = 10000000;
        Point start = null;
        Point exit = null;
        int[][] graph = new int[r][c];
        int[][] distance = new int[r][c];
        for(int i=0;i<r;i++) {
            st = new StringTokenizer(br.readLine());
            String row = st.nextToken();
            // System.out.println(row);
            for(int j=0;j<c;j++) {
                char current = row.charAt(j);
                if(current == 'T') {
                    graph[i][j] = -1;
                    distance[i][j] = INF;
                } else if(current == 'E') {
                    graph[i][j] = 0;
                    exit = new Point(i,j);
                    distance[i][j] = 0;
                } else if(current == 'S') {
                    graph[i][j] = 0;
                    start = new Point(i,j);
                    distance[i][j] = INF;
                } else {
                    graph[i][j] = current-'0';
                    distance[i][j] = INF;
                }
            }
        }
        LinkedList<Point> queue = new LinkedList<>();
        queue.offer(exit);
        while(!queue.isEmpty()) {
            Point curr = queue.poll();
            int[][] move = {{-1, 0},{1, 0},{0, -1},{0, 1}};
            for(int i=0;i<move.length;i++) {
                Point next = new Point(curr.x + move[i][0], curr.y + move[i][1]);
                if(next.x < r && next.x >=0 && next.y < c && next.y >=0 && graph[next.x][next.y] != -1) {
                    if(distance[next.x][next.y] > distance[curr.x][curr.y] + 1) {
                        distance[next.x][next.y] = distance[curr.x][curr.y] + 1;
                        queue.offer(next);
                    }
                } 
            }
        }
        int myDist = distance[start.x][start.y];
        int count = 0;
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(graph[i][j] > 0 && distance[i][j] <= myDist) {
                    count+= graph[i][j];
                }
                // System.out.print(distance[i][j] + " ");
            }
            // System.out.println();
        }
        System.out.print(count);
    }
}
class Point {
    int x,y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
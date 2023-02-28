import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class RookBishopAndKing {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        int rook = (r1!=r2?1:0) + (c1!=c2?1:0);
        int king = Math.max(Math.abs(c2-c1),Math.abs(r2-r1));
        int bishop;
        if((((r1+c1)%2) != ((r2+c2)%2)) || (r1 == r2 && c1 == c2))
            bishop = 0;
        else if(Math.abs(r2-r1) == Math.abs(c2-c1))
            bishop = 1;
        else 
            bishop = 2;
        out.print(rook + " " + bishop + " " + king);
        out.flush();
    }
}
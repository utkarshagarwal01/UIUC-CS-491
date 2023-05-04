import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.ArrayList;

public class DistinctCharactersQueries {
    ArrayList<TreeSet<Integer>> charSets;

    public DistinctCharactersQueries(String s) {
        this.charSets = new ArrayList<TreeSet<Integer>>();
        for(int i=0;i<26;i++) {
            this.charSets.add(new TreeSet<>());
        }
        int n = s.length();
        for(int i=0;i<n;i++) {
            char c = s.charAt(i);
            this.charSets.get(c-'a').add(i);
        }
    }

    public static void main(String[] args) throws IOException{
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] str = s.toCharArray();
        DistinctCharactersQueries obj = new DistinctCharactersQueries(s);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        while(q-->0) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if(type == 1) {
                int pos = Integer.parseInt(st.nextToken()) - 1;
                char replace = st.nextToken().charAt(0);
                obj.charSets.get(str[pos]-'a').remove(pos);
                obj.charSets.get(replace-'a').add(pos);
                str[pos] = replace;
            } else {
                int l = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken()) - 1;
                int count = 0;
                for(int i=0;i<26;i++) {
                    Integer next = obj.charSets.get(i).higher(l-1);
                    if(next!=null && next<= r) {
                        count++;
                        // out.write(i+" " + "Next: " + next);
                        // out.write("\n");
                    }
                }
                out.write(count +"\n"); 
            }
            out.flush();
        }
    }
}
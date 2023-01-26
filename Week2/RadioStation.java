import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class RadioStation {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, String> iptoname = new HashMap<String, String>();
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String ip = st.nextToken();
            iptoname.put(ip, name);
        }
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            String ip = st.nextToken();
            String ipTrimmed = ip.substring(0, ip.length()-1);
            System.out.println(command + " " + ip + " #" + iptoname.get(ipTrimmed));
        }
    }
}
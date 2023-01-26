import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LanguageDetection {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;
        while(true) {        
            String word = br.readLine();
            if(word.equals("#")) break;
            switch(word) {
                case "HELLO":
                    System.out.println("Case " + count + ": ENGLISH");
                    break;
                case "HOLA":
                    System.out.println("Case " + count + ": SPANISH");
                    break;
                case "HALLO":
                    System.out.println("Case " + count + ": GERMAN");
                    break;
                case "BONJOUR":
                    System.out.println("Case " + count + ": FRENCH");
                    break;
                case "CIAO":
                    System.out.println("Case " + count + ": ITALIAN");
                    break;
                case "ZDRAVSTVUJTE":
                    System.out.println("Case " + count + ": RUSSIAN");
                    break;
                default:
                    System.out.println("Case " + count + ": UNKNOWN");
            }
            count++;
        }
    }
}
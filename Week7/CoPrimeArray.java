import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
public class CoPrimeArray {
    public static void main(String[] args) throws IOException{
        CoPrimeArray obj = new CoPrimeArray();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a[] = new int[n];
        for(int i=0;i<n;i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int ans[] = new int[n-1];
        int seiveSize = 10000000;
        boolean sieve[] = obj.sieveOfEratosthenes(seiveSize);
        int inserts = 0;
        for(int i=0;i<n-1;i++) {
            HashSet<Integer> set1 = obj.distinctPrimeFactors(a[i]);
            HashSet<Integer> set2 = obj.distinctPrimeFactors(a[i+1]);
            HashSet<Integer> union = new HashSet<>(set1);
            union.addAll(set2);
            HashSet<Integer> intersection = new HashSet<>(set1);
            intersection.retainAll(set2);
            // System.out.println("Integers: " + a[i] + " " + a[i+1]);
            // for(Integer x: union) 
            //     System.out.print(x + " ");
            // System.out.println();
            // for(Integer x: intersection) 
            //     System.out.print(x + " ");
            // System.out.println();
            if(intersection.size() > 0) {
                for(int j=2;j<=seiveSize;j++) {
                    if(sieve[j] && !union.contains(j)) {
                        ans[i] = j;
                        inserts++;
                        break;
                    }
                }
            }
        }
        System.out.println(inserts);
        for(int i=0;i<n;i++) {
            System.out.print(a[i] + " ");
            if(i!=n-1 && ans[i] != 0) {
                System.out.print(ans[i] + " ");
            }
        }
    }

    public boolean[] sieveOfEratosthenes(int n)
    {
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<=n;i++)
            prime[i] = true;
        for(int p = 2; p*p <=n; p++)
            if(prime[p] == true)
                for(int i = p*p; i <= n; i += p)
                    prime[i] = false;
        return prime;
    }

    public HashSet<Integer> distinctPrimeFactors(int N)
    {
        HashSet<Integer> primes = new HashSet<Integer>();
        if(N<2) return primes;
        if(N == 2) {
            primes.add(N);
            return primes;
        }
        for(int i=2;i*i<=N;i++) {
            int count=0;
            while(N%i==0) {
                if(count==0) {
                    primes.add(i);
                }
                N /= i;
            }
        }
        if(N > 2) {
            primes.add(N);
        }
        return primes;
    }
}
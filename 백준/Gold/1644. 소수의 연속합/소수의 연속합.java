import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main{
    public static boolean[] primes = new boolean[40000001];
    public static long[] sum = new long[300000];
    //    public static ArrayList<Long> sum = new ArrayList<>();
    public static HashSet<Long> sum2 = new HashSet<>();
    public static int idx;

    public static void init(){
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i <= 2000; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= 4000000; j+=i) {
                    primes[j]=false;
                }
            }
        }

        idx = 1;
        sum[0]=0;
//        sum.add(0L);
        sum2.add(0L);
        for (int i = 0; i <= 4000000; i++) {
            if (primes[i]) {
                sum[idx] = sum[idx - 1] + i;
                sum2.add(sum[idx]);
//                sum.add(sum.get(idx - 1) + i);
                idx++;
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init();

        int input = Integer.parseInt(br.readLine());
        int ans = 0;

//        System.out.println(idx);

        for (int i = 0; i < idx; i++) {
            if (sum[i] < input) {
                continue;
            }
            if (sum2.contains(sum[i] - input)) {
//                System.out.println(sum[i]+" "+i);
                ans++;
            }


//            if (sum.get(i) < input) {
//                continue;
//            }
//            if (sum.contains(sum.get(i) - input)) {
//                ans++;
//            }
        }

        System.out.println(ans);
    }
}
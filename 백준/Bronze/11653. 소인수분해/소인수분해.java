import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 10000000;
        boolean [] prime = new boolean[max+1];
        Arrays.fill(prime,true);
        prime[0] = prime[1] = false;
        for (int i=2;i*i<=max;i++){
            if (prime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    prime[j] = false;
                }
            }
        }

        int n = Integer.parseInt(br.readLine());
        while(n!=1){
            for (int i=2;i<=n;i++){
                if (prime[i]&&n%i==0){
                    System.out.println(i);
                    n/=i;
                    break;
                }
            }
        }

    }
}

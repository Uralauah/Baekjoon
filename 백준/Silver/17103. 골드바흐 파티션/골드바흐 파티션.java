import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n=1000000;
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime,true);
        prime[0] = prime[1] = false;
        for (int i=2;i*i<=n;i++){
            if (prime[i]){
                for (int j=i*i;j<=n;j+=i){
                    prime[j]=false;
                }
            }
        }

        int t=Integer.parseInt(br.readLine());
        for (int i=0;i<t;i++){
            int num=Integer.parseInt(br.readLine());
            int cnt=0;
            for (int j=0;j<=num/2;j++){
                if (prime[j]&&prime[num-j])
                    cnt++;
            }
            System.out.println(cnt);
        }
    }
}

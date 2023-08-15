import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int sum=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<t;i++){
            int num = Integer.parseInt(st.nextToken());
            if (isPrime(num)){
                sum++;
            }

        }
        System.out.println(sum);
    }

    public static boolean isPrime(int num){
        if (num==1)
            return false;
        for (int i=2;i<=(int)Math.sqrt(num);i++){
            if (num % i ==0)
                return false;

        }
        return true;
    }
}

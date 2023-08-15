import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken()), num2 = Integer.parseInt(st.nextToken());
        for (int i=num1;i<=num2;i++){
            if (isPrime(i))
                sb.append(i).append('\n');
        }
        System.out.println(sb);
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
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i=0;i<t;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken()), num2 = Integer.parseInt(st.nextToken());
            int gcd, lcm;
            gcd = GCD(num1,num2);
            lcm = num1*num2/gcd;
            sb.append(lcm).append('\n');
        }
        System.out.println(sb);
    }

    public static int GCD(int num1, int num2){
        if (num1 % num2 == 0)
            return num2;
        return GCD(num2,num1%num2);
    }
}

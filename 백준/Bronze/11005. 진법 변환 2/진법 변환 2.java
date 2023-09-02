import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());

        while(n>=b){
            int a = n%b;
            n/=b;
            char num=change(a);
            sb.append(num);
        }
        sb.append(change(n));
        sb.reverse();
        System.out.println(sb);
    }

    static char change(int n){
        char num;
        if (n>=0&&n<10)
            num=(char)(n+48);
        else
            num=(char)(n+55);
        return num;
    }
}
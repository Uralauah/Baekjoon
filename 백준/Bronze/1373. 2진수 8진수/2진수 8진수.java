import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String num = br.readLine();
        int len = num.length();
        for (int i=len-1;i>=0;i--){
            int sum=0;
            int a=1;
            for (int j=0;j<3;j++){
                sum+=Integer.valueOf(num.charAt(i)-48)*a;
                a*=2;
                if(j!=2)
                    i--;
                if(i<0)
                    break;
            }
            sb.append(sum);
        }
        sb.reverse();
        System.out.println(sb);
    }
}
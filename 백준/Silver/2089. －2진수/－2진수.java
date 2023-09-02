import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int a;
        while(num!=1){
            if (num==0)
                break;
            a=num%(-2);
            if (a==-1){
                num=num/(-2)+1;
                sb.append(1);
            }
            else{
                num=num/(-2);
                sb.append(a);
            }
        }
        sb.append(num);
        sb.reverse();
        System.out.println(sb);
    }
}

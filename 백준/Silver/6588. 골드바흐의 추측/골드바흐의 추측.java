import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int max =1000001;
        boolean [] prime = new boolean[max];
        prime[0]=prime[1]=true;
        for (int i=2;i<=Math.sqrt(max);i++){
            if (prime[i]==true)
                continue;
            for (int j=i*i;j<prime.length;j=j+i)
                prime[j]=true;
        }


        int num=1;
        while(true){
            num=Integer.parseInt(br.readLine());
            int pass=0;
            if (num==0)
                break;
            for (int i=num-1;i>=num/2;i--){
                if (!prime[i]&&!prime[num-i]){
                    sb.append(num).append(" = ").append(num-i).append(" + ").append(i).append('\n');
                    pass=1;
                    break;
                }
            }
            if (pass==0)
                sb.append("Goldbach's conjecture is wrong.\n");
        }
        System.out.println(sb);
    }
}

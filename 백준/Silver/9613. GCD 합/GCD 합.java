import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0;i<t;i++){
            long count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int j=0;j<n;j++){
                arr[j]=Integer.parseInt(st.nextToken());
            }
            for (int j=0;j<n;j++){
                for (int k=j+1;k<n;k++){
                    count+=gcd(arr[j],arr[k]);
                }
            }
            System.out.println(count);
        }
    }

    public static int gcd (int a, int b){
        if (b==0) return a;
        return gcd(b,a%b);
    }
}

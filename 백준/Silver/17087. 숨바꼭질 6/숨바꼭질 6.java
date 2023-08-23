import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st2.nextToken());
        }
        if (n==1){
            if (s>arr[0])
                System.out.println(s-arr[0]);
            else
                System.out.println(arr[0]-s);
        }
        else{
            int result;
            if (s>arr[0])
                result = s-arr[0];
            else
                result = arr[0]-s;
            for (int i=1;i<n;i++){
                if (s>arr[i])
                    result = gcd(result,s-arr[i]);
                else
                    result = gcd(result,arr[i]-s);
            }
            System.out.println(result);
        }
    }

    public static int gcd (int a, int b){
        if (b==0) return a;
        return gcd(b,a%b);
    }
}
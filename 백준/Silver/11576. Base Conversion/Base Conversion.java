import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr = new int[m];
        List <Integer> arr2 = new ArrayList<>();

        int sum=0;
        int mul=1;
        for (int i=0;i<m;i++)
            arr[i]=Integer.parseInt(st2.nextToken());
        for (int i=m-1;i>=0;i--)
        {
            sum+=arr[i]*mul;
            mul*=a;
        }
        while(sum>=1){

            arr2.add(sum%b);
            sum/=b;
        }
        for (int i=arr2.size()-1;i>=0;i--){
            System.out.print(arr2.get(i));
            System.out.print(' ');
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean [] sw1 = new boolean[N];
        boolean [] sw2 = new boolean[N];
        boolean [] arr = new boolean[N];

        String begin = br.readLine();
        for (int i=0;i<begin.length();i++){
            if (begin.charAt(i)=='0'){
                sw1[i]=false;
                sw2[i]=false;
            }
            else{
                sw1[i]=true;
                sw2[i]=true;
            }
        }
        String ans = br.readLine();
        for (int i=0;i<N;i++){
            if (ans.charAt(i)=='0')
                arr[i]=false;
            else
                arr[i]=true;
        }
        int sum1=0, sum2 = 0;


        sw1[0]=!sw1[0];
        sw1[1]=!sw1[1];
        sum1+=1;
        for (int i=1;i<N;i++){
            if (sw1[i-1]!=arr[i-1]){
                sw1[i-1]=!sw1[i-1];
                sw1[i]=!sw1[i];
                if (i!=N-1)
                    sw1[i+1]=!sw1[i+1];
                sum1+=1;
            }
        }

        for (int i=1;i<N;i++){
            if (sw2[i-1]!=arr[i-1]){
                sw2[i-1]=!sw2[i-1];
                sw2[i]=!sw2[i];
                if (i!=N-1)
                    sw2[i+1]=!sw2[i+1];
                sum2+=1;
            }
        }

        if (!Arrays.equals(sw1,arr)&&!Arrays.equals(sw2,arr))
            System.out.println(-1);
        else if (Arrays.equals(sw1,arr)&&Arrays.equals(sw2,arr))
            System.out.println(Math.min(sum1,sum2));
        else if (Arrays.equals(sw1,arr))
            System.out.println(sum1);
        else
            System.out.println(sum2);
    }
}
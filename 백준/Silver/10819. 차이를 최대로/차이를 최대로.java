import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[n];
        for (int i = 0; i < n; i++)
            input[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(input);
        ArrayList<Integer> arr = new ArrayList<>(n);
        int i;
        for (i = 0; i < n / 2; i++) {
            if (i % 2 == 0) {
                arr.add(0, input[n - 1 - i]);
                arr.add(input[i]);
            } else {
                arr.add(0, input[i]);
                arr.add(input[n - 1 - i]);
            }
        }
        if(n%2!=0){
            if(Math.abs(arr.get(0)-input[i])>Math.abs(arr.get(arr.size()-1)-input[i])){
                arr.add(0,input[i]);
            }
            else{
                arr.add(input[i]);
            }
        }
        int ans=0;
//
//        for(i=0;i<n;i++)
//            System.out.printf(arr.get(i)+" ");
//        System.out.println();

        for(i=0;i<n-1;i++)
            ans+=Math.abs(arr.get(i)-arr.get(i+1));
        System.out.println(ans);
    }
}


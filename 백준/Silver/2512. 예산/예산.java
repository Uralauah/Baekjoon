import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static long budget;
    public static int N;
    public static int[] arr;

    public static int find(int high, int low) {
//        int mid = (high + low) / 2;
        int temp = 0;
        while (high >= low) {
            int mid = (high +low)/2;
            if (calc(mid)) {
                temp = mid;
                low = mid+1;
                continue;
            }
            high = mid-1;
        }
        return temp;
    }

    public static boolean calc(int money) {
        long temp = 0;
        for (int i = 0; i < N; i++) {
            temp += Math.min(money, arr[i]);
        }
        return temp <= budget;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        budget = Integer.parseInt(br.readLine());

        System.out.println(find(max, 0));

    }
}

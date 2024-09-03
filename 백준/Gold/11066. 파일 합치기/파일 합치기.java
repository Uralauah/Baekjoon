import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N + 1][N + 1];
            int[] num = new int[N + 1];
            int[] sum = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                num[j] = Integer.parseInt(st.nextToken());
                sum[j] = sum[j - 1] + num[j];
            }

            for (int j = 1; j <= N; j++) {
                for (int from = 1; from + j <= N; from++) {
                    int to = from + j;
                    arr[from][to] = Integer.MAX_VALUE;
                    for (int t = from; t < to; t++) {
                        arr[from][to] = Math.min(arr[from][to], arr[from][t] + arr[t+1][to] + sum[to] - sum[from - 1]);
                    }
                }
            }

            System.out.println(arr[1][N]);
        }

    }
}
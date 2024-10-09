import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][n + 1];
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a][b] = Math.max(arr[a][b], c);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int cnt = 1;

        while (!q.isEmpty() && cnt<m) {
            int size = q.size();

            while (size-- > 0) {
                int now = q.poll();
                for (int i = now; i <= n; i++) {
                    if (arr[now][i] != 0) {
                        if (dp[cnt + 1][i] < dp[cnt][now] + arr[now][i]) {
                            dp[cnt+1][i] = dp[cnt][now] + arr[now][i];
                            q.offer(i);
                        }
                    }
                }
            }
            cnt++;
        }

        int ans = 0;
        for (int i = 1; i <= m; i++) {
//            System.out.println(dp[i][n]);
            ans = Math.max(ans, dp[i][n]);
        }

        System.out.println(ans);
    }
}
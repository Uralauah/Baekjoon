

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
    public static int r, c, n;
    public static int[][] fuels;

    public static int dist(int i, int j) {
        return fuels[j][0] + fuels[j][1] - fuels[i][0] - fuels[i][1];
    }

    public static boolean find(int f) {
        int[] dp = new int[n + 2];

        Arrays.fill(dp, -1);
        dp[0] = f;
        fuels[0][2] = f;

        for (int i = 1; i < n + 2; i++) {
            for (int j = 0; j < i; j++) {
                if (fuels[j][0] > fuels[i][0] || fuels[j][1] > fuels[i][1]) {
                    continue;
                }

                if (dp[j] < dist(j, i)) {
                    continue;
                }

                dp[i] = Math.max(dp[i], dp[j] - dist(j, i) + fuels[i][2]);
            }
        }

        return dp[n + 1] >= 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(br.readLine());

        fuels = new int[n + 2][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            fuels[i][0] = Integer.parseInt(st.nextToken());
            fuels[i][1] = Integer.parseInt(st.nextToken());
            fuels[i][2] = Integer.parseInt(st.nextToken());
        }
        fuels[0] = new int[]{1, 1, 0};
        fuels[n + 1] = new int[]{r, c, 0};

        Arrays.sort(fuels, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] + o1[1]) - (o2[0] + o2[1]);
            }
        });

        int s = 1, e = r + c - 2;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (find(mid)) {
                e = mid - 1;
            } else
                s = mid + 1;
        }

        System.out.println(s);
    }
}
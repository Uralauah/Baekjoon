import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n,k;
    public static int ans = Integer.MAX_VALUE;
    public static int[][] arr;
    public static boolean[] visited;

    public static void calc(int cnt, int a, int sum) {
        if (ans < sum) {
            return;
        }
        if (cnt >= n) {
            ans = sum;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] || a == i) {
                continue;
            }
            visited[i] = true;
            calc(cnt + 1, i, sum + arr[a][i]);
            visited[i] = false;
        }
    }

    public static void update() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==j)
                    continue;
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        update();

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.printf(arr[i][j]+" ");
//            }
//            System.out.println();
//        }

        visited[k] = true;
        calc(1, k, 0);
        System.out.println(ans);
    }
}
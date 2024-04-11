import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int arr[][], input[][];
    public static int n, k;

    public static void dp() {
        for (int i = 1; i <= k; i++) {
            int time = input[i][1];
            int imp = input[i][0];
            for (int j = 1; j <= n; j++) {
                if (j < time) {
                    arr[i][j] = arr[i - 1][j];
                }
                else {
                    arr[i][j] = Math.max(arr[i - 1][j], imp + arr[i - 1][j - time]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[k + 1][n + 1];
        input = new int[k + 1][2];

        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }
        
        dp();

        System.out.println(arr[k][n]);
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int MAX_VALUE = 1000_001;
    public static int[] arr;
    public static int[] num;

    public static int find(int child) {
        if (arr[child] != child) {
            arr[child] = find(arr[child]);
        }
        return arr[child];
    }

    public static void union(int a, int b) {
        int ta = find(a);
        int tb = find(b);
        arr[ta] = find(tb);
        if (ta != tb) {
            num[tb] += num[ta];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        arr = new int[MAX_VALUE];
        num = new int[MAX_VALUE];
        for (int i = 0; i < MAX_VALUE; i++) {
            arr[i] = i;
            num[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            if (st.nextToken().equals("I")) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            } else {
                System.out.println(num[find(Integer.parseInt(st.nextToken()))]);
            }
        }
    }
}
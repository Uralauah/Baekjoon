import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{
    public static int n,m;
    public static int[] dp;

    public static class Node implements Comparable<Node> {
        int a,b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }


        @Override
        public int compareTo(Node o) {
            return this.b - o.b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new int[n + 1];
        Node[] input = new Node[m];

        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            input[i] = new Node(a, b);
        }

        Arrays.sort(input);

        for (int i = 0; i < m; i++) {
            Node now = input[i];
            dp[now.b] = Math.max(dp[now.b], dp[now.a] + 1);
        }

        for (int i = 1; i <= n; i++) {
            System.out.printf(dp[i]+" ");
        }


    }
}
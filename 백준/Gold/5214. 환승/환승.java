import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static int n,k,m;
    public static ArrayList<Integer>[] arr;

    public static int ans = Integer.MAX_VALUE;

    public static boolean[] visited;

    public static class Node{
        int idx;
        int cnt;

        public Node(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    public static void bfs(int start){
        visited = new boolean[n+m+1];
        visited[start] = true;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 1));
        while (!q.isEmpty()) {
            Node now = q.poll();
            if(now.idx == n){
                ans = Math.min(ans, now.cnt);
                return;
            }

            for (int i = 0; i < arr[now.idx].size(); i++) {
                int next = arr[now.idx].get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    if(next<=n){
                        q.add(new Node(next, now.cnt+1));
                    }
                    else{
                        q.add(new Node(next, now.cnt));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+m+1];
        for (int i = 1; i <= n+m; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int tube = n+1+i;
            for(int j=0;j<k;j++){
                int station = Integer.parseInt(st.nextToken());
                arr[tube].add(station);
                arr[station].add(tube);
            }
        }

        bfs(1);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
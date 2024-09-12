import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static int N, result = 0;
    public static int[] arr;
    public static ArrayList<Integer>[] road;
    public static HashSet<Integer> inside;
    public static boolean[] visited;

    public static int find(int start, int next) {
//        System.out.println("visit: "+next);
        if(visited[next])
            return 0;
        if (start!=next && inside.contains(next)) {
            return 1;
        }
        visited[next] = true;
        int temp = 0;

//        System.out.println(road[next].size());

        for (int i = 0; i < road[next].size(); i++) {
//            System.out.println(road[next].get(i));
            temp += find(start ,road[next].get(i));
        }
        return temp;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        road = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            road[i] = new ArrayList<>();
        }
        inside = new HashSet<>();

        String input = br.readLine();
        for (int i = 0; i < N; i++) {
            if (input.charAt(i) == '1') {
                inside.add(i + 1);
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            road[a].add(b);
            road[b].add(a);
        }

        for (int a : inside) {
//            System.out.println("start : "+a);
            visited = new boolean[N + 1];
//            inside.remove(a);
            result += find(a,a);
//            inside.add(a);
        }
        System.out.println(result);
    }
}
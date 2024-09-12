import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static int N, result = 0;
    public static ArrayList<Integer>[] road;
//    public static HashSet<Integer> outside;
    public static int[] arr;
    public static boolean[] visited;

    public static int find(int node) {
        int temp = 0;
//        System.out.println(node+" -------");
//        for (int i = 0; i < road[node].size(); i++) {
//            if (arr[road[node].get(i)]==1) {
//                visited[node] = true;
//                temp += find(road[node].get(i));
//            } else {
////                visited[road[node].get(i)] = true;
//                temp++;
//            }
//        }
        for (int a : road[node]) {
//            System.out.println(a);
            if (arr[a] == 0) {
                if (!visited[a]) {
                    visited[a] = true;
                    temp += find(a);
                }
            }
            else {
                temp++;
            }
        }
        return temp;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        road = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            road[i] = new ArrayList<>();
        }
//        outside = new HashSet<>();
        arr = new int[N + 1];

        String input = br.readLine();
        for (int i = 1; i <= N; i++) {
            if (input.charAt(i-1) == '1') {
                arr[i] =  1;
            } else {
//                outside.add(i + 1);
                arr[i] = 0;
            }
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (arr[a] == 1 && arr[b] == 1) {
                result += 2;
            }
            road[a].add(b);
            road[b].add(a);
        }

        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            int temp = 0;
            if (arr[i] == 0) {
                if (!visited[i]) {
                    visited[i] = true;
                    temp += find(i);
                }
            }
            result += temp * (temp - 1);
        }
        System.out.println(result);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static int n, ans = Integer.MAX_VALUE;
    public static int[] popul;
    public static ArrayList<Integer>[] arr;
    public static ArrayList<Integer> tA;
    public static boolean[] isSelected;

    public static void check() {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        
        // A 그룹 확인
        q.add(tA.get(0));
        visited[tA.get(0)] = true;
        int sumA = popul[tA.get(0)];
        int countA = 1;

        while (!q.isEmpty()) {
            int t = q.poll();
            for (int next : arr[t]) {
                if (isSelected[next] && !visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    sumA += popul[next];
                    countA++;
                }
            }
        }
        
        // 모든 A 그룹이 연결되지 않았다면 종료
        if (countA != tA.size()) return;

        // B 그룹 확인
        ArrayList<Integer> tB = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!isSelected[i]) {
                tB.add(i);
            }
        }
        
        if (tB.isEmpty()) return; // B 그룹이 비어있으면 종료

        q.add(tB.get(0));
        visited[tB.get(0)] = true;
        int sumB = popul[tB.get(0)];
        int countB = 1;

        while (!q.isEmpty()) {
            int t = q.poll();
            for (int next : arr[t]) {
                if (!isSelected[next] && !visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    sumB += popul[next];
                    countB++;
                }
            }
        }

        // 모든 B 그룹이 연결되지 않았다면 종료
        if (countB != tB.size()) return;

        ans = Math.min(ans, Math.abs(sumA - sumB));
    }

    public static void search(int index, int remaining) {
        if (remaining == 0) {
            check();
            return;
        }

        for (int i = index; i <= n; i++) {
            tA.add(i);
            isSelected[i] = true;
            search(i + 1, remaining - 1);
            tA.remove(tA.size() - 1);
            isSelected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];
        isSelected = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        popul = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            popul[i] = Integer.parseInt(st.nextToken());
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            while (cnt-- > 0) {
                arr[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i <= n / 2; i++) {
            tA = new ArrayList<>();
            search(1, i);
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}

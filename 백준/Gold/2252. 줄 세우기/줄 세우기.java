import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 비교 횟수

        ArrayList<Integer>[] arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        int[] in = new int[N + 1]; // 진입차수 배열

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            arr[f].add(s); // f가 s보다 앞에 있어야 한다
            in[s]++; // s의 진입차수 증가
        }

        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        // 진입차수가 0인 노드를 큐에 넣음
        for (int i = 1; i <= N; i++) {
            if (in[i] == 0) {
                q.offer(i);
            }
        }

        // 위상 정렬 시작
        while (!q.isEmpty()) {
            int a = q.poll();
            sb.append(a).append(" ");

            for (int next : arr[a]) {
                in[next]--; // 연결된 노드의 진입차수 감소
                if (in[next] == 0) {
                    q.offer(next); // 진입차수가 0이 되면 큐에 추가
                }
            }
        }

        // 결과 출력
        System.out.println(sb.toString().trim());
    }
}

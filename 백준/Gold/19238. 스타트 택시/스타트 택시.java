import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Loc {
        private int x;
        private int y;
        private int cnt;

        public Loc(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static int[][] arr;
    public static int N, M, fuel;
    public static int[][] destination;
    public static int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static Loc find(int x, int y) {
        Queue<Loc> q = new LinkedList<>();
        PriorityQueue<Loc> pq = new PriorityQueue<>((a, b) -> {
            if (a.cnt == b.cnt) {
                if (a.x == b.x) return Integer.compare(a.y, b.y);
                return Integer.compare(a.x, b.x);
            }
            return Integer.compare(a.cnt, b.cnt);
        });

        q.add(new Loc(x, y, 0));
        boolean[][] visited = new boolean[N + 2][N + 2];
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Loc now = q.poll();
            if (arr[now.x][now.y] > 1) {
                pq.add(now);  // 승객을 찾으면 우선순위 큐에 추가
            }

            for (int i = 0; i < 4; i++) {
                int tx = now.x + dir[i][0];
                int ty = now.y + dir[i][1];

                if (!visited[tx][ty] && arr[tx][ty] != 1 && check(tx, ty)) {
                    q.add(new Loc(tx, ty, now.cnt + 1));
                    visited[tx][ty] = true;
                }
            }
        }

        return pq.isEmpty() ? null : pq.poll();  // 가장 우선순위가 높은 승객 선택
    }


    public static Loc drive(int x, int y, int dx, int dy) {
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(x, y, 0));
        Loc result = null;
        boolean[][] visited = new boolean[N + 2][N + 2];
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Loc now = q.poll();
            if ((now.x == dx) && (now.y == dy)) {
                result = new Loc(now.x, now.y, now.cnt);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int tx = now.x + dir[i][0];
                int ty = now.y + dir[i][1];

                if (!visited[tx][ty] && arr[tx][ty] != 1 && check(tx, ty)) {
                    q.add(new Loc(tx, ty, now.cnt + 1));
                    visited[tx][ty] = true;
                }
            }
        }
        return result;
    }

    public static boolean check(int x, int y) {
        return x >= 1 && y >= 1 && x <= N && y <= N;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        arr = new int[N + 2][N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        destination = new int[M][2];

        for (int i = 2; i <= M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            arr[sx][sy] = i;
            destination[i - 2][0] = ex;
            destination[i - 2][1] = ey;
        }

//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.printf(arr[i][j]+" ");
//            }
//            System.out.println();
//        }


        for (int i = 0; i < M; i++) {
            Loc next = find(startX, startY);
            if (next == null) {
                fuel = -1;
//                System.out.println("승객 못태움");
                break;
            }
            Loc dest = drive(next.x, next.y, destination[arr[next.x][next.y] - 2][0], destination[arr[next.x][next.y] - 2][1]);
            if (dest == null) {
                fuel = -1;
//                System.out.println((arr[next.x][next.y]-1) + "번 승객 도착 못함");
                break;
            }

            if (fuel - next.cnt - dest.cnt < 0) {
                fuel = -1;
//                System.out.println("기름 모자람");
                break;
            }
            fuel -= next.cnt + dest.cnt;
            fuel += 2 * dest.cnt;
//            System.out.println((arr[next.x][next.y]-1) + "번 도착");
            arr[next.x][next.y] = 0;
            startX = dest.x;
            startY = dest.y;
        }

        System.out.println(fuel);
    }
}
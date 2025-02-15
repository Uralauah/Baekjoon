import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static int n,m;
    public static char[][] arr;

    public static boolean[][] visited;
    public static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static boolean find(int px, int py, int x, int y,int len) {
        visited[x][y] = true;

//        System.out.println("visit!! : "+px+" "+py+" "+arr[px][py]+" "+x+" "+y+" "+arr[x][y]);

        for (int i = 0; i < 4; i++) {
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];

            if(check(dx, dy))
                continue;

            if (arr[x][y] != arr[dx][dy])
                continue;

            if (!visited[dx][dy]) {
                if(find(x, y, dx, dy, len+1))
                    return true;
            } else if (dx != px || dy != py) {
                if (len >= 4) {
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean check(int x, int y) {
        return x < 1 || x > n || y < 1 || y > m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n + 2][m + 2];
        visited = new boolean[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = input.charAt(j - 1);
            }
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!visited[i][j]) {
                    if (find(-1, -1, i, j, 1)) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }
        System.out.println("No");
    }
}
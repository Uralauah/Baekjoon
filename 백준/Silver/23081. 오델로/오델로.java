import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dir = {{0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}};

        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = input.charAt(j);
            }
        }


        int ans = Integer.MIN_VALUE;
        int ans_x=0,ans_y=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '.') {
                    int cnt = 0;
                    for (int k = 0; k < 8; k++) {
                        int dx = j + dir[k][0];
                        int dy = i + dir[k][1];
                        if (dx < 0 || dx >= n || dy < 0 || dy >= n) {
                            continue;
                        }
                        int temp = 0;

                        while (!(dx < 0 || dx >= n || dy < 0 || dy >= n)) {
                            if(arr[dy][dx]=='.')
                                break;

                            if(arr[dy][dx]=='B'){
                                cnt+=temp;
                                break;
                            }
                            temp++;

                            dx += dir[k][0];
                            dy += dir[k][1];
                        }
//                        while (arr[dx][dy] != 'B') {
//                            if(arr[dx][dy]=='.')
//                                break;
//                            temp++;
//                            dx += dir[k][0];
//                            dy += dir[k][1];
//                            if (dx < 0 || dx >= n || dy < 0 || dy >= n) {
//                                break;
//                            }
//                        }
//                        if(!(dx < 0 || dx >= n || dy < 0 || dy >= n)&&arr[dx][dy] == 'B')
//                            cnt+=temp;
                    }
                    if (ans < cnt) {
                        ans = cnt;
                        ans_x = j;
                        ans_y = i;
                    }
                }
            }
        }

        if (ans == 0) {
            System.out.println("PASS");
        } else {
            System.out.println(ans_x + " "+ ans_y);
            System.out.println(ans);
        }
    }
}
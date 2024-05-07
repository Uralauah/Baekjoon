#include <iostream>
#include <string>
#include <cstring>

#define MAXINT 101
using namespace std;

char arr[MAXINT][MAXINT];
int dp[MAXINT][MAXINT][MAXINT];
int n, m, k, len, sum = 0, dir[4][2] = {0, 1, 0, -1, 1, 0, -1, 0};
string input;

int find(int idx, int x, int y) {
    if (dp[x][y][idx] != -1) {
        return dp[x][y][idx];
    }
    if (idx >= len)
        return 1;

    dp[x][y][idx] = 0;

    for (int i = 0; i < 4; i++) {
        for (int j = 1; j <= k; j++) {
            int tx = x + dir[i][0] * j;
            int ty = y + dir[i][1] * j;
            if (tx < 1 || tx > n || ty < 1 || ty > m)
                continue;
            if (arr[tx][ty] == input[idx]) {
                dp[x][y][idx] += find(idx + 1, tx, ty);
            }
        }
    }
    return dp[x][y][idx];
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> n >> m >> k;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++)
            cin >> arr[i][j];
    }

    memset(dp, -1, sizeof(dp));

    cin >> input;
    len = input.length();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (arr[i][j] == input[0])
                sum += find(1, i, j);
        }
    }
    cout << sum;
}
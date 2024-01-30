#include <iostream>
#include <algorithm>

using namespace std;

char board[21][21];
int arr[4][2] = {1, 0, -1, 0, 0, 1, 0, -1};
int r, c, ans;

bool check(int x, int y) {
    if (x >= 0 && x < r && y >= 0 && y < c)
        return true;
    else
        return false;
}

void find(bool visited[27], int x, int y, int sum) {
    int tx, ty;
    if (ans < sum)
        ans = sum;
    for (int i = 0; i < 4; i++) {
        tx = x + arr[i][0];
        ty = y + arr[i][1];

        if (check(tx, ty)) {
            if (!visited[board[tx][ty] - 'A']) {
                visited[board[tx][ty] - 'A'] = true;
                find(visited, tx, ty, sum + 1);
                visited[board[tx][ty] - 'A'] = false;
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> r >> c;
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++)
            cin >> board[i][j];
    }
    bool visited[27] = {false};
    visited[board[0][0] - 'A'] = true;
    find(visited, 0, 0, 1);
    cout << ans;
}
#include <iostream>
#include <vector>

using namespace std;

int n, arr[101][101], dir[4][2] = {0, 1, 0, -1, 1, 0, -1, 0}, ans = 0;
bool visited[101][101];

bool check(int x, int y) {
    if (x < 1 || x > n || y < 1 || y > n)
        return false;
    return true;
}

void find(int h, int x, int y) {
//    cout << h << " " << x << " " << y << endl;
    visited[x][y] = true;
    for (int i = 0; i < 4; i++) {
        int tx = x + dir[i][0];
        int ty = y + dir[i][1];
        if (check(tx, ty) && !visited[tx][ty] && arr[tx][ty] > h) {
            find(h, tx, ty);
        }
    }
}

int main() {
    cin >> n;
    int top = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            cin >> arr[i][j];
            top = max(top, arr[i][j]);
        }
    }
    for (int i = 0; i < top; i++) {
//        cout << "height = " << i << endl;
        int temp = 0;
        for (int j = 1; j <= n; j++) {
            for (int k = 1; k <= n; k++) {
                if (!visited[j][k] && arr[j][k] > i) {
                    find(i, j, k);
                    temp++;
                }
            }
        }
//        cout << "result = " << temp << endl;
        ans = max(temp, ans);
        for (int j = 1; j <= n; j++) {
            for (int k = 1; k <= n; k++)
                visited[j][k] = false;
        }
    }
    cout << ans;
}
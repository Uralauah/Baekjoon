#include <iostream>

using namespace std;

char arr[101][101];
bool visited[101][101];
int n, dir[2][2] = {0, 1, 1, 0};
int ans = 0;

bool check(int x, int y) {
    if (x < 1 || x > n || y < 1 || y > n)
        return false;
    return true;
}

void find(int x, int y, int idx) {
    int sum = 0;
    int tx = x;
    int ty = y;
    visited[x][y] = true;
//    cout << "x y >>>>> " << x << " " << y << endl;
    sum++;
    while (true) {
        tx += dir[idx][0];
        ty += dir[idx][1];
        if (!check(tx, ty))
            break;
//        cout << tx << " " << ty << endl;
        if (!visited[tx][ty] && arr[tx][ty] != 'X') {
            visited[tx][ty] = true;
//            cout << "sum++\n";
            sum++;
        } else
            break;
    }
    if (sum >= 2) {
//        cout << "ans++\n";
        ans++;
    }
}

int main() {
    cin >> n;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            cin >> arr[i][j];
        }
    }
    for (int i = 0; i < 2; i++) {
        for (int j = 1; j <= n; j++) {
            for (int k = 1; k <= n; k++) {
                if (!visited[j][k] && arr[j][k] != 'X')
                    find(j, k, i);
            }
        }
        for (int j = 1; j <= n; j++) {
            for (int k = 1; k <= n; k++)
                visited[j][k] = false;
        }
        cout << ans << " ";
        ans = 0;
    }
}
#include <iostream>

using namespace std;

char arr[601][601];
bool visited[601][601];
int dir[4][2] = {1, 0, -1, 0, 0, 1, 0, -1}, sum = 0, n, m;

bool check(int x, int y) {
    if (x < 0 || x >= n || y < 0 || y >= m)
        return false;
    return true;
}

void dfs(int x, int y) {
    visited[x][y] = true;
    if (arr[x][y] == 'P')
        sum++;
    int tx, ty;
    //cout << "xy : " << x << " " << y << endl;
    for (int i = 0; i < 4; i++) {

        tx = x + dir[i][0];
        ty = y + dir[i][1];
        //cout << "xy - " << x << " " << y << " " << "txty : " << tx << " " << ty << endl;
        if (arr[tx][ty] == 'X')
            continue;
        if (check(tx, ty) && !visited[tx][ty]) {
            dfs(tx, ty);
        }
    }
}

int main() {
    int x, y;
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> arr[i][j];
            if (arr[i][j] == 'I') {
                x = i;
                y = j;
            }
        }
    }
    dfs(x, y);
    if (sum > 0)
        cout << sum;
    else
        cout << "TT";

}
#include <iostream>
#include <queue>

using namespace std;

int dir[4][2] = {1, 0, -1, 0, 0, 1, 0, -1};
int map[1002][1002];
queue<pair<int, int>> q;

int n, m;

bool check(int x, int y) {
    if (x < 1 || x >= n + 1 || y < 1 || y >= m + 1 || map[x][y] == 0)
        return false;
    return true;
}

void find() {
    int tx, ty;
    while (!q.empty()) {
        pair<int, int> temp = q.front();
        q.pop();
        //cout << temp.first << " " << temp.second << endl;
        for (int i = 0; i < 4; i++) {
            tx = temp.first + dir[i][0];
            ty = temp.second + dir[i][1];
            if (check(tx, ty)) {
                if (map[tx][ty] == -1 || map[ty][ty] > map[temp.first][temp.second] + 1) {
                    map[tx][ty] = map[temp.first][temp.second] + 1;
                    q.push({tx, ty});
                }
            }
        }
    }
}

int main() {
    int x, y, input;
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            cin >> input;
            if (input == 1)
                input = -1;
            map[i][j] = input;
            if (map[i][j] == 2) {
                x = i;
                y = j;
                map[i][j] = 0;
            }
        }
    }
    q.push({x, y});
    find();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++)
            cout << map[i][j] << " ";
        cout << "\n";
    }
}

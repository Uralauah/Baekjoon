#include <iostream>
#include <queue>
#include <string>

using namespace std;

int map[101][101], temp[4][2] = {0, 1, 0, -1, 1, 0, -1, 0};
int n, m;
queue<pair<int, int>> q;
bool visited[100][100] = {false};

void find() {
    while (!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        int sum = map[x][y];
        //cout << x << " " << y << " " << sum << endl;
//        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int tempx = x + temp[i][0];
            int tempy = y + temp[i][1];
            if ((tempx < 0 || tempx >= n) || (tempy < 0 || tempy >= m))
                continue;
            if (!visited[tempx][tempy] && map[tempx][tempy]) {
                q.push({tempx, tempy});
                map[tempx][tempy] = sum + 1;
                visited[tempx][tempy] = true;
            }
        }

    }
}

int main() {
    string input;
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> input;
        for (int j = 0; j < m; j++) {
            map[i][j] = input[j] - '0';
        }
    }

    q.push({0, 0});
    find();


//    for (int i = 0; i < n; i++) {
//        for (int j = 0; j < m; j++) {
//            cout << map[i][j] << " ";
//        }
//        cout << endl;
//    }
    cout << map[n - 1][m - 1];
}
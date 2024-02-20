#include <iostream>
#include <cmath>
#include <queue>
#include <set>

using namespace std;

int n, l, r, ans = 0;
int city[51][51], dir[4][2] = {1, 0, -1, 0, 0, 1, 0, -1};
bool visited[51][51];
queue<pair<int, int>> q, q2, ali;
set<pair<int, int>> s;

bool check(int x, int y) {
    if (x < 1 || x > n || y < 1 || y > n)
        return false;
    return true;
}

void find(int x, int y) {
    q.push({x, y});
    ali.push({x, y});
    int people = city[x][y];
    visited[x][y] = true;
    //cout << "xy       " << x << " " << y << endl;
    while (!q.empty()) {
        x = q.front().first;
        y = q.front().second;
        q.pop();
        for (int i = 0; i < 4; i++) {
            int tx = x + dir[i][0];
            int ty = y + dir[i][1];
            if (check(tx, ty)) {
                if (!visited[tx][ty]) {
                    int sum = abs(city[x][y] - city[tx][ty]);
                    if (sum >= l && sum <= r) {
                        ali.push({tx, ty});
                        q.push({tx, ty});
                        visited[tx][ty] = true;
                        people += city[tx][ty];
                    } else {
                        s.insert({tx, ty});
                    }
                }
            }
        }
    }

    people = people / ali.size();
//    cout << people << endl;
    while (!ali.empty()) {
//        cout << ali.front().first << " " << ali.front().second << endl;
        city[ali.front().first][ali.front().second] = people;
        ali.pop();
    }
    if (!s.empty()) {
        ans++;
        while (true) {
            if (s.empty())
                break;
            x = (*s.begin()).first;
            y = (*s.begin()).second;
            s.erase(s.begin());
            if (!visited[x][y])
                break;
        }
        find(x, y);
    }
}

int main() {
    cin >> n >> l >> r;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            cin >> city[i][j];
        }
    }

    int sum = 0;
    while (true) {
        sum++;
        find(1, 1);
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++)
//                cout << city[i][j] << " ";
//            cout << endl;
//        }
//        cout << ans << endl;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                visited[i][j] = false;
        }
        if (ans == n * n - 1)
            break;
        ans = 0;
    }
    cout << sum - 1;
}

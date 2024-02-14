#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<pair<int, int>> v[10001];
bool visited[10001];
int n, ans = 0, start;

void find(int num, int sum) {
    visited[num] = true;

    if (ans < sum) {
        start = num;
        ans = sum;
    }

    for (int i = 0; i < v[num].size(); i++) {
        if (!visited[v[num][i].second]) {
            find(v[num][i].second, sum + v[num][i].first);
        }
    }
}

int main() {
    cin >> n;
    int a, b, c;
    for (int i = 0; i < n - 1; i++) {
        cin >> a >> b >> c;
        v[a].push_back({c, b});
        v[b].push_back({c, a});
    }
    find(1, 0);
    for (int i = 0; i <= n; i++)
        visited[i] = false;
    ans = 0;
    find(start, 0);
    cout << ans;
}
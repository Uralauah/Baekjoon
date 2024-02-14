#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<pair<int, int>> v[100001];
bool visited[100001];
int n, ans = 0, start;

void find(int num, int sum) {
    visited[num] = true;

    if (ans < sum) {
        start = num;
        ans = sum;
    }

    for (int i = 0; i < v[num].size(); i++) {
        if (!visited[v[num][i].first]) {
            find(v[num][i].first, sum + v[num][i].second);
        }
    }
}

int main() {
    cin >> n;
    int a, b, c;
    for (int i = 0; i < n; i++) {
        cin >> a;
        while (true) {
            cin >> b;
            if (b == -1)
                break;
            cin >> c;
            v[a].push_back({b, c});
            v[b].push_back({a, c});
        }
    }
    find(1, 0);
    for (int i = 1; i <= n; i++)
        visited[i] = false;
    ans = 0;
    find(start, 0);
    cout << ans;
}
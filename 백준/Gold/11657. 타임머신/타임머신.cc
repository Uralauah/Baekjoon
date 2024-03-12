#include <iostream>
#include <vector>
#include <queue>

#define INF 1e9

using namespace std;

int n, m;
vector<pair<int, pair<int, int>>> v;
long long arr[501];

bool find() {
    arr[1] = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = 0; j < m; j++) {
            int from = v[j].first;
            int next = v[j].second.first;
            long long dist = v[j].second.second;

            if (arr[from] == INF)
                continue;

            if (arr[next] > arr[from] + dist) {
                arr[next] = arr[from] + dist;
                if (i == n)
                    return false;
            }
        }
    }
    return true;
}

int main() {
    cin >> n >> m;
    int a, b, c;
    for (int i = 0; i < m; i++) {
        cin >> a >> b >> c;
        v.push_back({a, {b, c}});
    }
    for (int i = 1; i <= n; i++) {
        arr[i] = INF;
    }
    if (find()) {
        for (int i = 2; i <= n; i++) {
            if (arr[i] == INF)
                cout << -1 << "\n";
            else
                cout << arr[i] << "\n";
        }
    } else
        cout << -1;
}
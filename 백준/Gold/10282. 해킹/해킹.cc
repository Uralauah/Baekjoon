#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

#define INF 987654321

using namespace std;


int n, d, c, total = 0, ans = 0;

int arr[10001];

void find(vector<pair<int, int>> v[]) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({0, c});
    arr[c] = 0;
    while (!pq.empty()) {
        int node = pq.top().second;
        int sec = pq.top().first;
        pq.pop();
        if (arr[node] < sec)
            continue;
        for (int i = 0; i < v[node].size(); i++) {
            int next = v[node][i].second;
            int temp = v[node][i].first + sec;

            if (arr[next] > temp) {
                arr[next] = temp;
                pq.push({temp, next});
            }
        }
    }
    for (int j = 1; j <= n; j++) {
        if (arr[j] != INF) {
            total++;
            ans = max(ans, arr[j]);
        }
    }
    cout << total << " " << ans << '\n';
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t;
    cin >> t;
    int a, b, s;
    for (int i = 0; i < t; i++) {
        vector<pair<int, int>> v[10001];
        cin >> n >> d >> c;
        for (int j = 1; j <= d; j++) {
            cin >> a >> b >> s;
            v[b].push_back({s, a});
        }
        fill_n(arr, 10001, INF);
        find(v);
        total = 0, ans = 0;
    }
}
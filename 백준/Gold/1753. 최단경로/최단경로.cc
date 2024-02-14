#include <iostream>
#include <vector>
#include <queue>

using namespace std;
vector<pair<int, int>> edge[20001];
int ans[20001];
int v, e, k;

void find() {
    priority_queue<pair<int, int>> pq;
    pq.push({0, k});
    while (!pq.empty()) {
        int dis = -pq.top().first;
        int node = pq.top().second;
        pq.pop();

        if (ans[node] < dis)
            continue;
        for (int i = 0; i < edge[node].size(); i++) {
            int cost = dis + edge[node][i].first;
            if (cost < ans[edge[node][i].second]) {
                ans[edge[node][i].second] = cost;
                pq.push({-cost, edge[node][i].second});
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> v >> e >> k;
    int a, b, c;
    for (int i = 0; i <= v; i++) {
        if (i == k)
            continue;
        ans[i] = 1000000;
    }
    for (int i = 0; i < e; i++) {
        cin >> a >> b >> c;
        edge[a].push_back({c, b});
    }
    find();
    for (int i = 1; i <= v; i++) {
        if (ans[i] == 1000000) {
            cout << "INF\n";
            continue;
        }
        cout << ans[i] << "\n";
    }
}
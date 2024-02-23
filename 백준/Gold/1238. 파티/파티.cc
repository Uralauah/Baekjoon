#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int n, m, x;
vector<pair<int, int>> v[1001];
int arr[1001][1001];

void find(int num) {
    priority_queue<pair<int, int>> pq;
    pq.push({0, num});
    while (!pq.empty()) {
        int dis = -pq.top().first;
        int node = pq.top().second;
        pq.pop();

        for (int i = 0; i < v[node].size(); i++) {
            int new_dis = dis + v[node][i].second;
            int next = v[node][i].first;
            if (arr[num][next] < new_dis)
                continue;
            if (arr[num][next] > new_dis) {
                arr[num][next] = new_dis;
                pq.push({-new_dis, next});
            }
        }
    }
}

int main() {
    int a, b, c;
    cin >> n >> m >> x;
    for (int i = 0; i < m; i++) {
        cin >> a >> b >> c;
        v[a].push_back({b, c});
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (j == i)
                continue;
            arr[i][j] = 1000000;
        }
    }
    for (int i = 1; i <= n; i++) {
        find(i);
    }
    int ans = 0;
    for (int i = 1; i <= n; i++) {
        if (arr[i][x] + arr[x][i] > ans)
            ans = arr[i][x] + arr[x][i];
    }
    cout << ans;
}
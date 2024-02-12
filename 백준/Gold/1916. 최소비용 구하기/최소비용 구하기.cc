#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int n, m, start, dest;
int arr[1001][1001], d[1001];
vector<pair<int, int>> v[1001];
bool visited[1001];

void find() {
    priority_queue<pair<int, int>> pq;
    pq.push({0, start});
    d[start] = 0;
    while (!pq.empty()) {
        int dis = pq.top().first;
        int node = pq.top().second;
        pq.pop();
        //cout << node << endl;
        if (dis > d[node])
            continue;
        for (int i = 0; i < v[node].size(); i++) {
            int temp = dis + v[node][i].second;
            if (temp < d[v[node][i].first]) {
                d[v[node][i].first] = temp;
                pq.push({temp, v[node][i].first});
            }
        }
    }
}

int main() {
    cin >> n >> m;
    int a, b, price;
    for (int i = 0; i < m; i++) {
        cin >> a >> b >> price;
        v[a].push_back({b, price});
    }
    for (int i = 1; i <= n; i++) {
        d[i] = 100000000;
    }
    cin >> start >> dest;
    find();
    cout << d[dest];
}
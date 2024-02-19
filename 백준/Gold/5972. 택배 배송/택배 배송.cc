#include<iostream>
#include <queue>
#include <vector>

using namespace std;

int n, m;
vector<pair<int, int>> v[50001];
long long arr[50001];

void find() {
    priority_queue<pair<int, int>> pq;
    pq.push({0, 1});
    while (!pq.empty()) {
        int node = pq.top().second;
        int cow = -pq.top().first;
        pq.pop();
        if (arr[node] < cow)
            continue;
        for (int i = 0; i < v[node].size(); i++) {
            int temp_node = v[node][i].second;
            int temp_cow = cow - v[node][i].first;

            if (arr[temp_node] > temp_cow) {
                arr[temp_node] = temp_cow;
                pq.push({-temp_cow, temp_node});
            }
        }
    }
}

int main() {
    cin >> n >> m;
    int a, b, c;
    for (int i = 0; i < m; i++) {
        cin >> a >> b >> c;
        v[a].push_back({-c, b});
        v[b].push_back({-c, a});
    }
    for (int i = 0; i <= n; i++)
        arr[i] = 100000000000;
    find();
    cout << arr[n];
}
#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> v[1001];
queue<int> q;
int n;
bool visited[1001];

void dfs(int a) {
    visited[a] = true;
    cout << a << " ";
    for (int i = 0; i < v[a].size(); i++) {
        if (!visited[v[a][i]]) {
            dfs(v[a][i]);
        }
    }
}

void bfs(int a) {
    visited[a] = true;
    q.pop();
    cout << a << " ";
    for (int i = 0; i < v[a].size(); i++) {
        if (!visited[v[a][i]])
            q.push(v[a][i]);
    }
    while (!q.empty()) {
        if (visited[q.front()])
            q.pop();
        else {
            bfs(q.front());
        }
    }
}

int main() {
    int m, s, a, b;
    cin >> n >> m >> s;
    for (int i = 0; i < m; i++) {
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    for (int i = 0; i <= n; i++) {
        sort(v[i].begin(), v[i].end());
    }
    dfs(s);
    for (int i = 0; i <= n; i++)
        visited[i] = false;
    cout << "\n";
    q.push(a);
    bfs(s);
}
#include <iostream>
#include <vector>

using namespace std;

vector<int> v[1001];
int n;
bool visited[1001];

void dfs(int a) {
    visited[a] = true;
    for (int i = 0; i < v[a].size(); i++) {
        if (!visited[v[a][i]]) {
            dfs(v[a][i]);
        }
    }
}

int main() {
    int m, a, b, sum = 0;
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }

    for (int i = 1; i <= n; i++) {
        if (!visited[i]) {
            //cout << i << " ";
            sum++;
            dfs(i);
        }
    }
    cout << sum;
}
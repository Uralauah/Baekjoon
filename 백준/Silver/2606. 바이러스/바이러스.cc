#include <iostream>
#include <vector>

using namespace std;

vector<int> v[101];
bool visited[101];
int sum = 0;

void dfs(int n) {
    sum++;
    visited[n] = true;
    for (int i = 0; i < v[n].size(); i++) {
        if (!visited[v[n][i]])
            dfs(v[n][i]);
    }
}

int main() {
    int n, m, c1, c2;
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        cin >> c1 >> c2;
        v[c1].push_back(c2);
        v[c2].push_back(c1);
    }
    dfs(1);
    cout << sum - 1;
}
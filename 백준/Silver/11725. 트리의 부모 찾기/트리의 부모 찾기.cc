#include <iostream>
#include <vector>

using namespace std;

int n;
vector<int> v[100001];
bool visited[100001];
int ans[100001];

void dfs(int num) {
    visited[num] = true;

    for (int i = 0; i < v[num].size(); i++) {
        if (!visited[v[num][i]]) {
            ans[v[num][i]] = num;
            dfs(v[num][i]);
        }
    }
}

int main() {
    cin >> n;
    int a, b;
    for (int i = 0; i < n - 1; i++) {
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    dfs(1);
    for (int i = 2; i <= n; i++)
        cout << ans[i] << "\n";
}
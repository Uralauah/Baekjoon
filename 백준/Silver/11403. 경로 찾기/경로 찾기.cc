#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

vector<int> v[101];
bool visited[101];

void dfs(int n) {
    for (int i = 0; i < v[n].size(); i++) {
        if (!visited[v[n][i]]) {
            visited[v[n][i]] = true;
            dfs(v[n][i]);
        }
    }
}

int main() {
    int n, input;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            cin >> input;
            if (input == 1) {
                v[i].push_back(j);
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        memset(visited, false, sizeof(visited));
        dfs(i);
        for (int j = 1; j <= n; j++)
            cout << visited[j] << " ";
        cout << '\n';
    }
//    for (int i = 1; i <= n; i++) {
//        for (int j = 1; j <= n; j++)
//            cout << ans[i][j] << " ";
//        cout << "\n";
//    }
}
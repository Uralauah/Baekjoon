#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int n;
vector<int> v[51];
int arr[51];

void bfs(int a) {
    priority_queue<pair<int, int>> pq;
    pq.push({0, a});
    arr[a] = 0;
    while (!pq.empty()) {
        int dist = -pq.top().first;
        int node = pq.top().second;
        pq.pop();
//        cout << dist << " " << node << " " << arr[node] << endl;
        if (arr[node] < dist)
            continue;
        for (int i = 0; i < v[node].size(); i++) {
            int next = v[node][i];
//            cout << "next >> " << next << endl;
            if (arr[next] > dist + 1) {
                arr[next] = dist + 1;
//                cout << "next" << " " << next << " " << dist + 1 << "\n";
                pq.push({-(dist + 1), next});
            }
        }
    }
}


int main() {
    cin >> n;
    int a, b, temp = 10000;
    vector<int> ans;
    while (true) {
        cin >> a >> b;
        if (a == -1 && b == -1)
            break;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            arr[j] = 100000;
        }
        bfs(i);
//        for (int j = 1; j <= n; j++)
//            cout << arr[j] << " ";
//        cout << endl;
        int stu = 0;
        for (int j = 1; j <= n; j++) {
            stu = max(stu, arr[j]);
        }
        if (temp > stu) {
            ans.clear();
            ans.push_back(i);
            temp = stu;
        } else if (temp == stu)
            ans.push_back(i);
    }
    cout << temp << " " << ans.size() << '\n';
    for (int i = 0; i < ans.size(); i++)
        cout << ans[i] << " ";
}
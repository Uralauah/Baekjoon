#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
    int n, k;

    vector<int> v;
    queue<int> q;
    cin >> n >> k;
    for (int i = 1; i <= n; i++) {
        v.push_back(i);
    }
    int idx = k - 1;
    while (!v.empty()) {
        while (idx >= v.size()) {
            idx -= v.size();
        }
        q.push(v[idx]);
        v.erase(v.begin() + idx);
        idx += k - 1;
    }
    cout << "<";
    for (int i = 0; i < n - 1; i++) {
        cout << q.front() << ", ";
        q.pop();
    }
    cout << q.front() << ">";

}

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;
int n, m;
vector<string> v;
vector<string> ans;

bool find(string name) {
    int start = 0, end = n - 1, mid;
    while (start <= end) {
        mid = (start + end) / 2;
        if (v[mid] == name)
            return true;
        else if (v[mid] > name)
            end = mid - 1;
        else
            start = mid + 1;
    }
    return false;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int sum = 0;
    cin >> n >> m;
    string name;
    for (int i = 0; i < n; i++) {
        cin >> name;
        v.push_back(name);
    }
    sort(v.begin(), v.end());
    for (int i = 0; i < m; i++) {
        cin >> name;
        if (find(name))
            ans.push_back(name);
    }
    sort(ans.begin(), ans.end());
    cout << ans.size() << "\n";
    for (int i = 0; i < ans.size(); i++) {
        cout << ans[i] << "\n";
    }
}
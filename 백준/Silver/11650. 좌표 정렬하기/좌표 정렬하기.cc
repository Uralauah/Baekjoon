#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

bool cmp(int a[2], int b[2]) {
    if (a[0] != b[0])
        return a[0] < b[0];
    else {
        return a[1] < b[1];
    }
}

int main() {
    int n, x, y;
    vector<pair<int, int>> v;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> x >> y;
        v.push_back(pair<int, int>(x, y));
    }
    sort(v.begin(), v.end());
    for (int i = 0; i < n; i++) {
        cout << v[i].first << " " << v[i].second << "\n";
    }

}
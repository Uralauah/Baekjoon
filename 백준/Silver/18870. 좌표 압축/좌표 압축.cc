#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(pair<int, int> a, pair<int, int> b) {
    return a.second < b.second;
}

int main() {
    vector<pair<int, int>> v;
    int n, input, temp = -1, num = 0;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> input;
        v.push_back({input, i});
    }
    sort(v.begin(), v.end());
    for (int i = 0; i < n; i++) {
        if (v[i].first == temp) {
            v[i].first = v[i - 1].first;
        } else {
            temp = v[i].first;
            v[i].first = num++;
        }
    }
    sort(v.begin(), v.end(), cmp);
    for (int i = 0; i < n; i++) {
        cout << v[i].first << " ";
    }
}
#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

bool cmp(pair<int, int> a, pair<int, int> b) {
    if (a.second == b.second) {
        return a.first < b.first;
    }
    return a.second < b.second;
}

int main() {
    pair<int, int> arr[100000];
    int n;
    int x, y;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> x >> y;
        arr[i] = pair<int, int>(x, y);
    }
    sort(arr, arr + n, cmp);
    for (int i = 0; i < n; i++) {
        cout << arr[i].first << " " << arr[i].second << "\n";
    }

}
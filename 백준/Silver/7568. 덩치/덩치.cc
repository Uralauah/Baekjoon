#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(pair<int, int> a, pair<int, int> b) {
    return a.first > b.first;
}

bool cmp2(pair<int, int> a, pair<int, int> b) {
    return a.second > b.second;
}

int main() {
    pair<int, int> arr[51];
    pair<int, int> temp[51];
    int score[51];
    int n, x, y, num = 1;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> x >> y;
        arr[i] = pair<int, int>(x, y);
        temp[i] = pair<int, int>(x, y);
    }
//    sort(temp, temp + n, cmp);
//    sort(arr, arr + n, cmp2);
//    for (int i = 0; i < n; i++) {
//        cout << temp[i].first << " : " << temp[i].second << " - " << arr[i].first << " : " << arr[i].second << endl;
//    }
    for (int i = 0; i < n; i++) {
        int sum = 0;
        for (int j = 0; j < n; j++) {
            if (arr[i].first < arr[j].first && arr[i].second < arr[j].second) {
                sum++;
            }
        }
        cout << sum + 1 << " ";
    }
}
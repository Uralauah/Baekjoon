#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> v, arr;
vector<vector<int>> ans;

int main() {
    int n, m;
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        v.push_back(i);
    }
    for (int i = 0; i < n; i++) {
        if (i < m)
            arr.push_back(1);
        else
            arr.push_back(0);
    }
//    for (int i = 0; i < n; i++)
//        cout << arr[i] << " ";
//    cout << endl;
    vector<int> temp;
    do {
        temp.clear();
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                temp.push_back(i + 1);
            }
        }
        ans.push_back(temp);
    } while (prev_permutation(arr.begin(), arr.end()));
    sort(ans.begin(), ans.end());

    for (int i = 0; i < ans.size(); i++) {
        for (int j = 0; j < ans[i].size(); j++)
            cout << ans[i][j] << " ";
        cout << endl;
    }
}
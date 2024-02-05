#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    vector<int> input, temp, temp_ans;
    vector<vector<int>> ans;
    int n, m, num;
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> num;
        input.push_back(num);
    }
    for (int i = 0; i < n; i++) {
        if (i < m)
            temp.push_back(0);
        else
            temp.push_back(1);
    }
    sort(input.begin(), input.end());
    do {
        temp_ans.clear();
        for (int i = 0; i < input.size(); i++) {
            if (!temp[i])
                temp_ans.push_back(input[i]);
        }
        do {
            ans.push_back(temp_ans);
        } while (next_permutation(temp_ans.begin(), temp_ans.end()));
    } while (next_permutation(temp.begin(), temp.end()));

    sort(ans.begin(), ans.end());
    for (int i = 0; i < ans[0].size(); i++)
        cout << ans[0][i] << " ";
    cout << "\n";
    for (int i = 1; i < ans.size(); i++) {
        bool flag = false;
        for (int j = 0; j < ans[i].size(); j++) {
            if (ans[i - 1][j] != ans[i][j]) {
                flag = true;
                break;
            }
        }
        if (flag) {
            for (int j = 0; j < ans[i].size(); j++)
                cout << ans[i][j] << " ";
            cout << "\n";
        }
    }
}
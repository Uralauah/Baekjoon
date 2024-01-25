#include <iostream>
#include <vector>

using namespace std;

int main() {
    int t, n, m;
    cin >> t;
    for (int i = 0; i < t; i++) {
        cin >> n;
        int arr[1001] = {0}, temp[1001][3] = {0};
        int max = 0, win = 0;
        vector<int> v;
        for (int j = 0; j < n; j++) {
            cin >> m;
            if (max < m)
                max = m;
            v.push_back(m);
            arr[m]++;
        }
        for (int j = v.size() - 1; j >= 0; --j) {
            if (arr[v[j]] < 6) {
                
                arr[v[j]] = 0;
                v.erase(v.begin() + j);

            }
        }
        for (int j = 0; j < v.size(); j++) {
            temp[v[j]][0]++;
            if (temp[v[j]][0] == 5) {
                temp[v[j]][2] += j;
                continue;
            }
            if (temp[v[j]][0] > 5)
                continue;
            temp[v[j]][1] += j;
        }
        temp[0][0] = 6;
        temp[0][1] = 1000;
        temp[0][2] = 1000;


        for (int j = 1; j <= max; j++) {
            if (temp[j][0] < 6)
                continue;
            if (temp[j][1] < temp[win][1])
                win = j;
            else if (temp[j][1] == temp[win][1]) {
                if (temp[j][2] == 0)
                    continue;
                if (temp[j][2] < temp[win][2])
                    win = j;
            }
        }
        cout << win << "\n";
    }
}
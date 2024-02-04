#include <iostream>
#include <vector>
#include <algorithm>
#include <iterator>

using namespace std;

vector<int> v;

int main() {
    int n, input, good = 0;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> input;
        v.push_back(input);
    }
    sort(v.begin(), v.end());
//    for (int i = 0; i < n; i++)
//        cout << v[i] << " ";
//    cout << endl;
    for (int i = 0; i < n; i++) {
//        cout << i << endl;
        for (int j = 0; j < n; j++) {
            if (i == j)
                continue;
            bool flag = false;
            auto it = v.begin();
            int add = j + 1;
            while (it != v.end()) {
                it = find(v.begin() + add, v.end(), v[i] - v[j]);

//                cout << v[i] << " " << v[j] << " + " << v[i] - v[j] << endl;
                if (it == v.begin() + i) {
                    add++;
                    continue;
                }
                if (it != v.end()) {
                    good++;
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
        }
    }
    cout << good;
}
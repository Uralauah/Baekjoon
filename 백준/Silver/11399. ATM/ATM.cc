#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    vector<int> v;
    int n, p;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> p;
        v.push_back(p);
    }
    sort(v.begin(), v.end());
    int sum = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j <= i; j++) {
            sum += v[j];
        }
    }
    cout << sum;
}
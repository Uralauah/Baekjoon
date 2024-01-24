#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    vector<int> v;
    int n, k, a, sum = 0;
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        cin >> a;
        v.push_back(a);
    }
    while (k != 0) {
        if (k < v.back()) {
            v.pop_back();
            continue;
        }
        k -= v.back();
        sum++;
    }
    cout << sum;
}
#include <iostream>
#include <cmath>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n, input, no;
    double sum = 0;
    vector<int> v;
    cin >> n;
    if (n != 0) {
        for (int i = 0; i < n; i++) {
            cin >> input;
            v.push_back(input);
        }
        sort(v.begin(), v.end());
        no = floor(n * 0.15 + 0.5);
        for (int i = no; i < n - no; i++) {
            sum += v[i];
        }
        sum = floor(sum / (n - no * 2) + 0.5);
    } else
        sum = 0;
    cout << sum;
}
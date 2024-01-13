#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int arr[15][15];

int find(int k, int n) {
    int sum = 0;
    if (arr[k][n]) {
        //cout << k << ":" << n << ":" << arr[k][n] << endl;
        return arr[k][n];

    } else {
        for (int i = 0; i < n; i++) {
            sum += find(k - 1, n - i);
        }
        //cout << sum << endl;
        arr[k][n] = sum;
        return sum;
    }
}

int main() {
    int t, k, n;
    cin >> t;
    for (int i = 0; i < 15; i++) {
        arr[0][i] = i;
    }
    for (int i = 0; i < t; i++) {
        cin >> k >> n;
        cout << find(k, n) << '\n';
    }
}
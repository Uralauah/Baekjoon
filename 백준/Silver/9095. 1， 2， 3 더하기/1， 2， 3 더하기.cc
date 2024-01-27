#include <iostream>

using namespace std;

int arr[12];

int find(int n) {
    if (!arr[n]) {
        return find(n - 1) + find(n - 2) + find(n - 3);
    } else
        return arr[n];
}

int main() {
    int t, n;

    arr[1] = 1, arr[2] = 2, arr[3] = 4;
    cin >> t;
    for (int i = 0; i < t; i++) {
        cin >> n;
        cout << find(n) << '\n';
    }
}
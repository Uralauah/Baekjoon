#include <iostream>

using namespace std;

long long arr[101];

long long find(int a) {
    if (arr[a] > 0)
        return arr[a];
    arr[a] = find(a - 2) + find(a - 3);
    return arr[a];
}

int main() {
    arr[1] = 1, arr[2] = 1, arr[3] = 1;

    int t, n;
    cin >> t;
    for (int i = 0; i < t; i++) {
        cin >> n;
        cout << find(n) << "\n";
    }
}
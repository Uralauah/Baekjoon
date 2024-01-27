#include <iostream>

using namespace std;

int arr[1001];

int find(int n) {
    if (!arr[n]) {
        arr[n] = (find(n - 1) + find(n - 2)) % 10007;
    }
    return arr[n];
}

int main() {
    arr[2] = 2;
    arr[1] = 1;
    int n;
    cin >> n;
    cout << find(n);
}
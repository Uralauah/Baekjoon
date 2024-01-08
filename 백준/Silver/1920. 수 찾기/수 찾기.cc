#include <iostream>
#include <algorithm>

using namespace std;

int arr[100001];


bool search(long n, int left, int right) {
    int middle = (left + right) / 2;
    if (left > right)
        return false;
    if (n == arr[middle])
        return true;
    else if (n > arr[middle])
        return search(n, middle + 1, right);
    else
        return search(n, left, middle - 1);
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int n, m;
    long input;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    sort(arr, arr + n);
    cin >> m;
    for (int i = 0; i < m; i++) {
        cin >> input;
        if (search(input, 0, n - 1))
            cout << 1 << '\n';
        else
            cout << 0 << '\n';
    }
}
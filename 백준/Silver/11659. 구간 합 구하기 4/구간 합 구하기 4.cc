#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    long long arr[100001] = {0};
    int n, m, a, b;
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        cin >> a;
        arr[i] = arr[i - 1] + a;
    }
    while (m--) {
        cin >> a >> b;
        cout << arr[b] - arr[a - 1] << "\n";
    }
}

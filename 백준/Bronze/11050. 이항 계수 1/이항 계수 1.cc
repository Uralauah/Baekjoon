#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int count(int n, int k) {
    if (n == k || k == 0)
        return 1;
    return count(n - 1, k - 1) + count(n - 1, k);
}

int main() {
    int n, k;

    cin >> n >> k;
    cout << count(n, k);
}

#include <iostream>
#include <vector>

using namespace std;

long long a, b, ans = 1000000;


void find(long long temp, long long sum) {
    if (temp == b) {
        if (sum < ans)
            ans = sum;
    }
    if (temp < b) {
        find(temp * 2, sum + 1);
        find(temp * 10 + 1, sum + 1);
    }
}

int main() {
    cin >> a >> b;
    find(a, 0);
    if (ans == 1000000)
        cout << -1;
    else
        cout << ans + 1;
}
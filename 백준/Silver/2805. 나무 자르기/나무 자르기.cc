#include <iostream>

using namespace std;

long long arr[1000001];
long long n, m, ma = 0, ans = 100000000;

int main() {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        if (arr[i] > ma)
            ma = arr[i];
    }

    long long mid, mi = 0;
    while (mi < ma) {

        long long sum = 0;
        mid = (ma + mi) / 2;
        //cout << mi << " " << mid << " " << ma << endl;
        for (int i = 0; i < n; i++) {
            if (arr[i] > mid)
                sum += arr[i] - mid;
        }
        if (sum >= m) {
            ans = mid;
            mi = mid + 1;
        } else if (sum < m)
            ma = mid;
    }
    if (ans == 100000000)
        ans = mid;
    cout << ans;
}
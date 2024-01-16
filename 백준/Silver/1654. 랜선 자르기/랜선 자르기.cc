#include <iostream>

using namespace std;

long long arr[10001], k, n;
long long mid;

int check(int idx) {
    return arr[idx] / mid;
}

void lan(long long start, long long end) {
    mid = (start + end) / 2;
    if (mid == 0) {
        mid++;
        return;
    }
    int sum = 0;
    for (int i = 0; i < k; i++) {
        sum += check(i);
    }
    if (mid < start && sum >= n) {
        return;
    }
    if (sum < n) {
        lan(start, mid - 1);
    } else {
        lan(mid + 1, end);
    }

}

int main() {
    mid = 0;

    cin >> k >> n;
    for (int i = 0; i < k; i++) {
        cin >> arr[i];
        mid += arr[i];
    }
//    if (mid == 1) {
//        mid = 1;
//    } else
    lan(0, mid);
    cout << mid;
}
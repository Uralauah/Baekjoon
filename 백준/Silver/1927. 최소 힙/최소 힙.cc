#include <iostream>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    priority_queue<long long> pq;

    long long n, input;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> input;
        if (input == 0) {
            if (pq.empty())
                cout << 0 << '\n';
            else {
                cout << -pq.top() << '\n';
                pq.pop();
            }
        } else
            pq.push(-input);
    }
}
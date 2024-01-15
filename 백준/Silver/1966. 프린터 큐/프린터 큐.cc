#include <iostream>
#include <queue>

using namespace std;

int main() {
    int t, n, m, input, imp, sum, max;
    int arr[10] = {0};

    cin >> t;
    for (int i = 0; i < t; i++) {
        sum = 0;
        cin >> n >> m;

        for (int j = 0; j < 10; j++)
            arr[j] = 0;
        priority_queue<int> pq;
        queue<pair<int, int>> q;
        for (int j = 0; j < n; j++) {
            cin >> input;
            q.push(pair<int, int>(j, input));
            pq.push(input);

        }

        pair<int, int> temp;
        while (!q.empty()) {
            temp = q.front();
            q.pop();
            if (temp.second == pq.top()) {
                pq.pop();
                sum++;
                if (temp.first == m) {
                    break;
                }
            } else
                q.push(temp);
        }

        cout << sum << endl;
    }
}
#include <iostream>

using namespace std;


int main() {
    int n, m, sum = 0, card = 0, temp = 0;
    int input[100];
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> input[i];
    }
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                if (i == j || j == k || i == k)
                    continue;
                temp = input[i] + input[j] + input[k];
                if (temp <= m && temp > sum) {
                    sum = temp;
                }
            }
        }
    }

    cout << sum;
}
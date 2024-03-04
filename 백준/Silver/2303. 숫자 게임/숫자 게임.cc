#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
int arr[1001];
vector<int> v[1001];

int main() {
    cin >> n;
    int a;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < 5; j++) {
            cin >> a;
            v[i].push_back(a);
        }
        int temp[5] = {0, 0, 0, 1, 1};
        do {
            int tsum = 0;
            for (int j = 0; j < 5; j++) {
                if (temp[j] == 0) {
                    tsum += v[i][j];
                }
            }
            if (tsum % 10 > arr[i]) {
                arr[i] = tsum % 10;
            }
        } while (next_permutation(temp, temp + 5));
    }
    int big = arr[0];
    int num = 0;
    for (int i = 1; i < n; i++) {
        if (arr[i] >= big) {
            num = i;
            big = arr[i];
        }
    }
    cout << num + 1;
}
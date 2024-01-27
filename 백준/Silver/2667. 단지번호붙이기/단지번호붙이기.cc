#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int arr[27][27], house[500] = {0};
bool visited[27][27];

int n;

void find(int x, int y, int sum) {
    visited[x][y] = true;

    if (arr[x][y] != 0) {
        house[sum]++;
        if (!visited[x - 1][y])
            find(x - 1, y, sum);
        if (!visited[x + 1][y])
            find(x + 1, y, sum);
        if (!visited[x][y - 1])
            find(x, y - 1, sum);
        if (!visited[x][y + 1])
            find(x, y + 1, sum);
    }
}

int main() {
    string input;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> input;
        for (int j = 0; j < n; j++) {
            arr[i][j + 1] = input[j] - '0';
        }
    }


    int sum = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (arr[i][j] != 0 && !visited[i][j]) {
                find(i, j, sum++);
            }
        }
    }
    cout << sum << '\n';

    sort(house, house + sum);
    for (int i = 0; i < sum; i++) {
        cout << house[i] << "\n";
    }
}
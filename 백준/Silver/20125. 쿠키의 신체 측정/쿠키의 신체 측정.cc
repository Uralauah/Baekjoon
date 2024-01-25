#include <iostream>

using namespace std;
char arr[1001][1001];

bool check(int x, int y) {
    int sum = 0;
    if (arr[x - 1][y] == '*')
        sum++;
    if (arr[x + 1][y] == '*')
        sum++;
    if (arr[x][y - 1] == '*')
        sum++;
    if (arr[x][y + 1] == '*')
        sum++;
    if (sum == 4)
        return true;
    return false;
}

int main() {
    int n, x, y;
    int sum = 0;

    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> arr[i][j];
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (check(i, j)) {
                x = i;
                y = j;
                break;
            }
        }
    }
    cout << x + 1 << " " << y + 1 << '\n';

    for (int i = y - 1; i >= 0; i--) {
        if (arr[x][i] == '_')
            break;
        sum++;
    }
    cout << sum << " ";
    sum = 0;
    for (int i = y + 1; i < n; i++) {
        if (arr[x][i] == '_')
            break;
        sum++;
    }
    cout << sum << " ";
    sum = 0;
    for (int i = x; i < n; i++) {
        if (arr[i][y] == '_')
            break;
        x = i;
        sum++;
    }
    cout << sum - 1 << " ";
    sum = 0;
    for (int i = x + 1; i < n; i++) {
        if (arr[i][y - 1] == '_')
            break;
        sum++;
    }
    cout << sum << " ";
    sum = 0;
    for (int i = x + 1; i < n; i++) {
        if (arr[i][y + 1] == '_')
            break;
        sum++;
    }
    cout << sum << " ";
    sum = 0;

}
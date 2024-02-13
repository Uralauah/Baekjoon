#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int min_arr[100001][3], max_arr[10001][3], input[3];
int dir[3][2] = {-1, 0, -1, -1, -1, 1};
int n;

//bool check(int x, int y) {
//    if (x < 0 || x >= n || y < 0 || y >= 3)
//        return false;
//    return true;
//}
//
//void dp_min() {
//    int x = 1, y, tx, ty;
//    for (; x < n; x++) {
//        for (y = 0; y < 3; y++) {
//
//            min_arr[x][y] = input[x][y] + min_arr[x + dir[0][0]][y + dir[0][1]];
//            for (int i = 1; i < 3; i++) {
//                tx = x + dir[i][0];
//                ty = y + dir[i][1];
//                if (!check(tx, ty))
//                    continue;
//                if (min_arr[x][y] > input[x][y] + min_arr[tx][ty])
//                    min_arr[x][y] = input[x][y] + min_arr[tx][ty];
//            }
//        }
//    }
//}
//
//void dp_max() {
//    int x = 1, y, tx, ty;
//    for (; x < n; x++) {
//        for (y = 0; y < 3; y++) {
//            max_arr[x][y] = input[x][y] + max_arr[x + dir[0][0]][y + dir[0][1]];
//            for (int i = 1; i < 3; i++) {
//                tx = x + dir[i][0];
//                ty = y + dir[i][1];
//                if (!check(tx, ty))
//                    continue;
//                if (max_arr[x][y] < input[x][y] + max_arr[tx][ty]) {
//                    max_arr[x][y] = input[x][y] + max_arr[tx][ty];
//                }
//            }
//        }
//    }
//}

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> input[0] >> input[1] >> input[2];
        for (int j = 0; j < 3; j++) {
            max_arr[i][j] = input[j];
            min_arr[i][j] = input[j];
        }
        if (i == 0) {
            continue;
        }
        max_arr[i][0] = max(max_arr[i - 1][0], max_arr[i - 1][1]) + input[0];
        max_arr[i][1] = max(max_arr[i - 1][0], max(max_arr[i - 1][1], max_arr[i - 1][2])) + input[1];
        max_arr[i][2] = max(max_arr[i - 1][1], max_arr[i - 1][2]) + input[2];

        min_arr[i][0] = min(min_arr[i - 1][0], min_arr[i - 1][1]) + input[0];
        min_arr[i][1] = min(min_arr[i - 1][0], min(min_arr[i - 1][1], min_arr[i - 1][2])) + input[1];
        min_arr[i][2] = min(min_arr[i - 1][1], min_arr[i - 1][2]) + input[2];
    }
//    dp_min();
//    dp_max();
    int min = min_arr[n - 1][0], max = max_arr[n - 1][0];
    for (int i = 1; i < 3; i++) {
        if (min > min_arr[n - 1][i])
            min = min_arr[n - 1][i];
        if (max < max_arr[n - 1][i])
            max = max_arr[n - 1][i];
    }
    cout << max << " " << min;
}
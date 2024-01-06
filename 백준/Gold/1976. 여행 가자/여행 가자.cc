#include <iostream>

using namespace std;

int city[201][201] = {0};
bool visited[201] = {false};
int n;

bool search(int trip, int next_trip) {

    if (trip == next_trip)
        return true;
    if (city[trip][next_trip] == 1) {
        return true;
    }
    for (int i = 1; i <= n; i++) {
        if (city[trip][i] == 1 && !visited[i]) {
            visited[i] = true;

            if (search(i, next_trip))
                return true;

        }
    }
    return false;
}

void reset() {
    for (int i = 1; i <= n; i++) {
        visited[i] = false;
    }
}

int main() {
    int m, trip = 0, next_trip;
    bool fail = false;
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            cin >> city[i][j];
        }
    }
    for (int i = 0; i < m; i++) {
        reset();
        cin >> next_trip;
        if (trip != 0) {
            if (!search(trip, next_trip)) {
                fail = true;
            }
        }
        trip = next_trip;
    }
    if (fail)
        cout << "NO";
    else
        cout << "YES";
}
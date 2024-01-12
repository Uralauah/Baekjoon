#include <iostream>

using namespace std;


int main() {
    long int n;
    cin >> n;
    int sum = 1, inc = 6, room = 0;
    while (n > sum) {
        sum += inc;
        inc += 6;
        room++;
    }
    if (n == 1)
        room = 0;
    cout << room + 1;
}
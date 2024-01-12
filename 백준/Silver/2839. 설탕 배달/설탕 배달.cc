#include <iostream>

using namespace std;


int main() {
    int n, sum = 0;
    cin >> n;

    int temp = n / 5;

    while (true) {
        if (n % 5 == 0)
            break;
        else {
            if ((n - temp * 5) % 3 == 0) {
                temp += (n - temp * 5) / 3;
                break;
            } else {
                temp--;
                if (temp == -1)
                    break;
            }
        }
    }
    cout << temp;
}
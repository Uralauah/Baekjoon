#include <iostream>

using namespace std;

int main() {
    double n, score[1001], max = 0;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> score[i];
        if (score[i] > max)
            max = score[i];
    }

    double sum = 0;

    for (int i = 0; i < n; i++) {
        sum += score[i] / max * 100;

    }
    cout.precision(15);
    cout << sum / n;
}
#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int n, x;
    int arr[250001];
    cin >> n >> x;
    for (int i = 0; i < n; i++)
        cin >> arr[i];
    int max = 0, sum = 1;
    for (int i = 0; i < x; i++)
        max += arr[i];
    int temp = max;
    for (int i = 1; i < n - x + 1; i++) {
        temp -= arr[i - 1];
        temp += arr[i + x - 1];
        if (temp > max) {
            max = temp;
            sum = 1;
        } else if (temp == max)
            sum++;
    }
    if (max == 0)
        cout << "SAD";
    else
        cout << max << "\n" << sum;
}
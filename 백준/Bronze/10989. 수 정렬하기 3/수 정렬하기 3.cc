#include <iostream>

using namespace std;

int arr[10001] = {0};

int main() {
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    int n, input, max = 0;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> input;
        arr[input]++;
        if (input > max)
            max = input;
    }
   
    for (int i = 1; i <= max; i++) {
        for (int j = 0; j < arr[i]; j++) {
            cout << i << '\n';
        }
    }
}
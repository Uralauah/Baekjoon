#include <iostream>

using namespace std;

bool arr[101];
int n;

void male(int s) {
    for (int i = 1; i <= n / s; i++) {
        arr[s * i] = !arr[s * i];
    }
}

void female(int s) {
    int sum = 0;
    arr[s] = !arr[s];
    for (int i = 1; i < n; i++) {
        if (s - i < 1 || s + i > n)
            break;
        if (arr[s - i] == arr[s + i]) {
            arr[s - i] = !arr[s - i];
            arr[s + i] = !arr[s + i];
        } else
            break;
    }
}

int main() {
    int s, input, p;
    cin >> n;
    for (int i = 1; i <= n; i++)
        cin >> arr[i];
    cin >> p;
    for (int i = 0; i < p; i++) {
        cin >> s >> input;
        if (s == 1)
            male(input);
        else if (s == 2)
            female(input);

    }
    for (int j = 1; j <= n; j++) {
        cout << arr[j] << " ";
        if (j % 20 == 0)
            cout << '\n';
    }
}
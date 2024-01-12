#include <iostream>

using namespace std;

int main() {
    int a, b, v;
    cin >> a >> b >> v;
    int result = 1;
    v -= a;
    if (v % (a - b) == 0)
        result += v / (a - b);
    else
        result += v / (a - b) + 1;
    //result += v / (a - b);
    cout << result;
}
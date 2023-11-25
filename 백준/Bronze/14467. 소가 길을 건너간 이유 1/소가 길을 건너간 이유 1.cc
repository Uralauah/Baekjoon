#include <iostream>
using namespace std;

int main() {
	int n, num, loc;
	int min=0;
	int arr[10][2] = { 0 };
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> num >> loc;
		if (arr[num - 1][0] == 0) {
			arr[num - 1][1] = loc;
			arr[num - 1][0]++;
		}

		else if (arr[num - 1][1] != loc) {
			arr[num - 1][0]++;
			arr[num - 1][1] = loc;
			min++;
		}
	}
	cout << min;
}
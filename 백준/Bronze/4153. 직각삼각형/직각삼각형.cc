#include <iostream>
#include <cmath>
using namespace std;

int main() {
	int a, b=0;
	int arr[3];
	int max = 0;
	while (1) {
		max = 0;
		b = 0;
		for (int i = 0; i < 3; i++) {
			cin >> arr[i];
			if (arr[max] < arr[i])
				max = i;
		}
		if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0)
			break;
		a = pow(arr[max], 2);
		for (int i = 0; i < 3; i++) {
			if (i == max)
				continue;
			b += pow(arr[i], 2);
		}
		if (a == b)
			cout << "right" << '\n';
		else
			cout << "wrong" << '\n';
	}
}
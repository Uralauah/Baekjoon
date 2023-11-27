#include <iostream>
using namespace std;
#define MAX 200007

int cal(int arr[], int fun, int sum, int n) {
	for (int i = 0; i < 4; i++) {
		if (fun - i <= 0) {
			fun = fun + n;
		}
		sum += arr[fun - i] * arr[fun + 1 - i] * arr[fun + 2 - i] * arr[fun + 3 - i];
	}
	return sum;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n, q, arr[MAX], fun, sum=0,temp;
	cin >> n >> q;
	for (int i = 1; i <= n; i++)
		cin >> arr[i];
	for (int i = 1; i < 7; i++) {
		arr[n + i] = arr[i];
	}
	for (int i = 1; i <= n; i++) {
		sum += arr[i] * arr[i + 1] * arr[i + 2] * arr[i + 3];
	}
	for (int i = 1; i <= q; i++) {
		cin >> fun;
		for (int i = 0; i < 4; i++) {
			temp = fun;
			if (fun - i <= 0) {
				temp = temp + n;
			}
			sum -= arr[temp - i] * arr[temp + 1 - i] * arr[temp + 2 - i] * arr[temp + 3 - i];
		}

		if (fun < 4) {
			arr[n + fun] = -arr[fun];
		}
		arr[fun] = -arr[fun];


		//for (int i = 1; i <= n+6; i++) {
		//	cout << arr[i] << " ";
		//}
		//cout << "\n";

		sum = cal(arr, fun, sum, n);
		cout << sum << '\n';
	}
}
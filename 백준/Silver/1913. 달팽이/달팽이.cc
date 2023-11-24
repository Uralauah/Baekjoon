#include <iostream>
using namespace std;
#define MAX 999

int arr[MAX][MAX];

int main() {
	int n, find, x, y, c = 1, num = 1;
	int ans[2];
	bool end = false;
	cin >> n >> find;
	x = n / 2;
	y = n / 2;
	ans[0] = x+1;
	ans[1] = y+1;
	arr[x--][y] = num++;
	while (true) {
		for (int i = 0; i < c; i++) {
			if (num == find) {
				ans[0] = x + 1;
				ans[1] = y + 1;
			}
			arr[x][y++] = num++;
		}
		c++;
		for (int i = 0; i < c; i++) {
			if (num == find) {
				ans[0] = x + 1;
				ans[1] = y + 1;
			}
			arr[x++][y] = num++;
		}
		for (int i = 0; i < c; i++) {
			if (num == find) {
				ans[0] = x + 1;
				ans[1] = y + 1;
			}
			arr[x][y--] = num++;
		}
		c++;
		for (int i = 0; i < c; i++) {
			if (num == find) {
				ans[0] = x + 1;
				ans[1] = y + 1;
			}
			arr[x--][y] = num++;
			if (num>n*n) {
				end = true;
				break;
			}
		}
		if (end)
			break;
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << arr[i][j] << " ";
		}
		cout << "\n";
	}
	cout << ans[0] << " " << ans[1];
}
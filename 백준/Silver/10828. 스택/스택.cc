#include <iostream>
#include <cmath>
#include <string>
using namespace std;

int main(void) {
	int n;
	string menu;
	int num, arr[10001] = {};
	int len = 0;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> menu;
		if (menu == "push")
		{
			cin >> num;
			arr[len++] = num;
		}
		else if (menu == "top")
		{
			if (len == 0)
				cout << -1 << endl;
			else
				cout << arr[len - 1] << endl;
		}
		else if (menu == "pop")
		{
			if (len == 0)
				cout << -1 << endl;
			else {
				cout << arr[len - 1] << endl;
				arr[len - 1] = -1;
				len--;
			}
		}
		else if (menu == "size")
		{
			cout << len << endl;
		}
		else if (menu == "empty")
		{
			if (len == 0)
				cout << 1 << endl;
			else
				cout << 0 << endl;
		}
	}
	return 0;
}
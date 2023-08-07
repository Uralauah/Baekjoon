#include <iostream>
#include <cmath>
#include <string>
using namespace std;

bool isPrime(int a)
{
	if (a == 1)
		return false;
	int b = (int)sqrt(a);
	for (int i = 2; i <= b; i++)
	{
		if (a % i == 0)
			return false;
	}
	return true;
}

bool isPelin(int a)
{
	string b = to_string(a);
	string c = to_string(a);
	int len = b.size();
	for (int i = 0; i < len / 2; i++)
	{
		char temp = b[i];
		b[i] = b[len - 1 - i];
		b[len - 1 - i] = temp;
	}
	if (b == c)
		return true;
	else
		return false;
}

int main() {
	int a;
	cin >> a;
	while (1)
	{
		if (isPrime(a))
		{
			if (isPelin(a))
			{
				cout << a << endl;
				return 0;
			}
			a++;
		}
		a++;
	}
}
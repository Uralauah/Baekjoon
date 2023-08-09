#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
	int t;
	cin >> t;
	for (int i = 0; i < t; i++)
	{
		string text;
		cin >> text;
		int a = 0, b = 0, c = 0;
		for (int i = 0; i < text.size(); i++)
		{
			if (text[i] == '(')
				a++;
			else if(text[i] == ')')
				b++;
			if (a < b)
			{
				c++;
				break;
			}
		}
		if (c==0&&a == b)
			cout << "YES" << endl;
		else
			cout << "NO" << endl;
	}
}
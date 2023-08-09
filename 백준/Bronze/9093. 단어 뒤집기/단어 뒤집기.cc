#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
	int t;
	cin >> t;
	cin.ignore();
	stack<char>s;
	for (int i = 0; i < t; i++)
	{
		
		string text;
		getline(cin, text);
		text += ' ';
		for (int i = 0; i < text.size(); i++)
		{
			if (text[i] == ' ')
			{
				while (!s.empty())
				{
					cout << s.top();
					s.pop();
				}
				cout << ' ';
			}
			else
			{
				s.push(text[i]);
			}
		}
		cout << endl;
	}
	return 0;
}
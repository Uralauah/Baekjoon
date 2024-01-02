#include <iostream>
using namespace std;

int main(){
	int b[601][601];
	int h, w, x, y, num;

	cin>>h>>w>>x>>y;
	for (int i=0;i<h+x;i++){
		for (int j=0;j<w+y;j++){
			cin>>num;
			b[i][j]=num;
		}
	}

	for (int i=x;i<h;i++){
		for (int j=y;j<=w+y;j++){
			b[i][j]-=b[i-x][j-y];
		}
	}

	for (int i=0;i<h;i++){
		for (int j=0;j<w;j++){
			cout<<b[i][j]<<" ";
		}
		cout<<endl;
	}
	
}
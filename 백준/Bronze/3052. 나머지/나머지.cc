#include <iostream>
using namespace std;

int main()
{
    int arr[1000]={0};
    int sum=0;
    for (int i=0;i<10;i++)
    {
        int a;
        cin>>a;
        arr[a%42]++;
    }
    for (int i=0;i<1000;i++)
    {
        if (arr[i]!=0)
            sum++;
    }
    cout<<sum;
}
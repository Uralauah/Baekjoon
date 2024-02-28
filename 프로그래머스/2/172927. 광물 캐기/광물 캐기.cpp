#include <string>
#include <vector>

using namespace std;

int ans=100000000,total;

int arr[11][3];

void find(vector<int>picks,int sum,int time){
    if(time==total){
        if(ans>sum)
            ans=sum;
    }
    bool found=false;
    for(int i=0;i<3;i++){
        if(picks[i]!=0){
            found=true;
            picks[i]-=1;
            find(picks,sum+arr[time][i],time+1);
            picks[i]+=1;
        }
    }
    if(!found){
        if(ans>sum)
            ans=sum;
    }
}

int solution(vector<int> picks, vector<string> minerals) {
    int answer = 0;
    total=0;
    for(int i=0;i<minerals.size();i++){
        if(minerals[i]=="diamond"){
            arr[i/5][0]+=1;
            arr[i/5][1]+=5;
            arr[i/5][2]+=25;
        }
        else if(minerals[i]=="iron"){
            arr[i/5][0]+=1;
            arr[i/5][1]+=1;
            arr[i/5][2]+=5;
        }
        else{
            arr[i/5][0]+=1;
            arr[i/5][1]+=1;
            arr[i/5][2]+=1;
        }
    }
    for(int i=0;i<11;i++){
        if(arr[i][0]!=0)
            total++;
    }
    find(picks,0,0);
    return ans;
}
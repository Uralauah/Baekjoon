class Solution {
    public void truck(int idx, int[]arr,int cap){
        for(;idx>=0;idx--){
            if(arr[idx]>cap){
                arr[idx]-=cap;
                break;
            }
            else{
                cap-=arr[idx];
                arr[idx] = 0;
            }
        }
    }
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        while(true){
            int temp = 0;
            int i=n-1;
            for(;i>=0;i--){
                if(deliveries[i]!=0||pickups[i]!=0){
                    temp++;
                    truck(i,deliveries,cap);
                    truck(i,pickups,cap);
                    answer+=(i+1)*2;
                    break;
                }
                else{
                    n--;
                }
            }
            
            if(temp==0)
                break;
        }
        return answer;
    }
}
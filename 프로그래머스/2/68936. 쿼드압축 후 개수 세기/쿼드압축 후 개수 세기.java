class Solution {
    public int zero =0, one = 0;
    
    public void count(int[][] arr, int x, int y, int len){
        int temp = arr[x][y];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(arr[x+i][y+j]!=temp){
                    count(arr,x,y,len/2);
                    count(arr,x+len/2,y,len/2);
                    count(arr,x,y+len/2,len/2);
                    count(arr,x+len/2,y+len/2,len/2);
                    return;
                }
            }
        }
        if(temp == 0)
            zero++;
        else
            one++;
    }
    
    public int[] solution(int[][] arr) {
        int[] answer = {};
        count(arr,0,0,arr[0].length);
        answer = new int[2];
        answer[0]=zero;
        answer[1]=one;
        return answer;
    }
}
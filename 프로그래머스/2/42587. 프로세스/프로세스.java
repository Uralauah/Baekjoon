import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        int[] temp = new int[priorities.length];
        for(int i=0;i<temp.length;i++){
            temp[i] = priorities[i];
        }
        Arrays.sort(temp);
        
        int p = temp.length-1;
        int i=0;
        
        while(true){
        
            if(temp[p]==priorities[i]){
                // System.out.println(p+" "+i+" "+answer);
                answer++;
                p--;
                priorities[i]=-1;
                if(location==i){
                    break;
                }
            }
            i=(i+1)%priorities.length;
        }
        
        
        return answer;
    }
}
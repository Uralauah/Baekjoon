import java.util.*;

class Solution {
    public int min = Integer.MAX_VALUE;
    public String[] gw;
    public boolean[] visited;
    
    
    public void find(String target, int idx, int cnt){
        if(gw[idx].equals(target)){
            min = Math.min(min,cnt);
            return;
        }
        
        for(int i=0;i<gw.length;i++){
            if(i==idx)
                continue;
            int diff = 0;
            for(int j=0;j<target.length();j++){
                if(gw[i].charAt(j)!=gw[idx].charAt(j)){
                    diff++;
                }
            }
            if(diff==1&&!visited[i]){
                visited[i] = true;
                find(target, i, cnt+1);
                visited[i] = false;
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        gw = words;
        visited = new boolean[words.length];
        
        int start = 0;
        
        for(int i=0;i<words.length;i++){
            int diff = 0;
            for(int j=0;j<target.length();j++){
                if(words[i].charAt(j)!=begin.charAt(j)){
                    diff++;
                }
            }
            if(diff==1){
                visited[i] = true;
                find(target, i, 1);
                visited[i] = false;
            }
        }
        
        if(min==Integer.MAX_VALUE)
            answer = 0;
        else 
            answer = min;
        return answer;
    }
}